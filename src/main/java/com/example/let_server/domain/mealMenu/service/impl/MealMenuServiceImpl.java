package com.example.let_server.domain.mealMenu.service.impl;

import com.example.let_server.domain.allergy.service.AllergyService;
import com.example.let_server.domain.meal.domain.Meal;
import com.example.let_server.domain.meal.domain.MealType;
import com.example.let_server.domain.meal.dto.response.MaxEatersMealWithCountResponse;
import com.example.let_server.domain.meal.dto.response.MealDailyResponse;
import com.example.let_server.domain.meal.dto.response.MealResponse;
import com.example.let_server.domain.meal.error.MealError;
import com.example.let_server.domain.meal.service.MealService;
import com.example.let_server.domain.mealMenu.domain.MealMenu;
import com.example.let_server.domain.mealMenu.repository.MealMenuRepository;
import com.example.let_server.domain.mealMenu.service.MealMenuService;
import com.example.let_server.domain.menu.domain.Menu;
import com.example.let_server.domain.menu.dto.MenuResponse;
import com.example.let_server.domain.menu.service.MenuService;
import com.example.let_server.domain.menuAllergy.service.MenuAllergyService;
import com.example.let_server.global.error.CustomException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MealMenuServiceImpl implements MealMenuService {

    // Constants
    private static final String API_URL_TEMPLATE =
            "https://open.neis.go.kr/hub/mealServiceDietInfo?ATPT_OFCDC_SC_CODE=D10&SD_SCHUL_CODE=7240454&KEY=%s&MLSV_FROM_YMD=%s&MLSV_TO_YMD=%s&Type=json&MMEAL_SC_CODE=%d&pSize=100";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static final DateTimeFormatter YEAR_MONTH_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM");
    private static final Pattern ALLERGY_PATTERN = Pattern.compile("\\((\\d+(?:\\.\\d+)*)\\)");
    private static final int MAX_ALLERGY_ID = 19;

    // Meal type mappings
    private static final Map<Integer, String> MEAL_TYPE_MAP = Map.of(
            1, "조식",
            2, "중식",
            3, "석식"
    );

    private final MealMenuRepository mealMenuRepository;
    private final RestTemplate restTemplate;
    private final MealService mealService;
    private final MenuAllergyService menuAllergyService;
    private final MenuService menuService;
    private final ObjectMapper objectMapper;
    private final AllergyService allergyService;

    @Value("${KEY}")
    private String apiKey;


    @Scheduled(cron = "0 0 0 1 * ?")
    @Transactional
    @PostConstruct
    public void fetchAndSaveMonthlyMeals() {
        log.info("월간 급식 데이터 수집 시작");

        LocalDate now = LocalDate.now();
        DateRange dateRange = createDateRange(now);

        MEAL_TYPE_MAP.keySet().forEach(mealType -> {
            try {
                fetchAndSaveMealData(dateRange, mealType);
            } catch (Exception e) {
                log.error("급식 데이터 수집 중 오류 발생. MealType: {}", mealType, e);
            }
        });

        log.info("월간 급식 데이터 수집 완료");
    }

    //이 기능 제발 쓰자 ㅜㅜ
    @Override
    public List<MealResponse> getMonthlyMenu(String period, List<Long> allergyIds) {
        String yearMonth = LocalDate.now().format(YEAR_MONTH_FORMATTER);

        MealType mealType = parseMealTypeOrThrow(period);

        Map<String, Object> params = new HashMap<>();
        params.put("yearMonth", yearMonth);
        params.put("mealType", mealType); // MealType enum의 name 값
        params.put("allergyList", allergyIds); // 알러지 ID 리스트

        for (Long allergyId : allergyIds){
            allergyService.findByAllergyId(allergyId);
        }

        List<MealMenu> mealMenus = mealMenuRepository.findMonthlyMealMenu(params);

        return groupMealMenusByMeal(mealMenus);
    }



    @Override
    public List<MaxEatersMealWithCountResponse> getMaxEatersPerMealType() {
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        return mealMenuRepository.findMaxEatersPerMealType(year, month);
    }

    @Override
    public List<MealDailyResponse> getMealDaily(Date today) {
        return mealMenuRepository.findMealDaily(today);
    }

    private MealType parseMealTypeOrThrow(String period) {
        try {
            return MealType.valueOf(period);
        } catch (IllegalArgumentException e) {
            throw new CustomException(MealError.MELA_TYPE_NOT_FOUND);
        }
    }

    private DateRange createDateRange(LocalDate date) {
        String fromDate = date.withDayOfMonth(1).format(DATE_FORMATTER);
        String toDate = date.withDayOfMonth(date.lengthOfMonth()).format(DATE_FORMATTER);
        return new DateRange(fromDate, toDate);
    }

    private void fetchAndSaveMealData(DateRange dateRange, int mealType) {
        String url = buildApiUrl(dateRange, mealType);

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            parseAndSave(response.getBody(), mealType);
        }
    }

    private String buildApiUrl(DateRange dateRange, int mealType) {
        return String.format(API_URL_TEMPLATE, apiKey, dateRange.from(), dateRange.to(), mealType);
    }

    private List<MealResponse> groupMealMenusByMeal(List<MealMenu> mealMenus) {
        Map<Integer, MealResponse> mealMap = new LinkedHashMap<>();

        for (MealMenu mealMenu : mealMenus) {
            Meal meal = mealMenu.getMeal();
            Menu menu = mealMenu.getMenu();

            MealResponse mealResponse = mealMap.computeIfAbsent(
                    meal.getMealId(),
                    k -> MealResponse.of(meal)
            );

            mealResponse.getMenus().add(MenuResponse.of(menu));
        }

        return new ArrayList<>(mealMap.values());
    }

    private void parseAndSave(String json, int mealType) {
        try {
            JsonNode root = objectMapper.readTree(json);
            JsonNode rows = root.path("mealServiceDietInfo").path(1).path("row");

            if (rows.isMissingNode()) {
                log.warn("급식 데이터가 없습니다. MealType: {}", mealType);
                return;
            }

            for (JsonNode row : rows) {
                processMealRow(row, mealType);
            }
        } catch (JsonProcessingException e) {
            log.error("JSON 파싱 중 오류 발생", e);
            throw new RuntimeException("급식 데이터 파싱 실패", e);
        }
    }

    private void processMealRow(JsonNode row, int mealType) {
        MealData mealData = extractMealData(row, mealType);
        Meal meal = mealService.createMeal(mealData.date(), mealData.type(), mealData.calories());

        mealData.menus().forEach(menuName -> processMenu(meal, menuName));
    }

    private MealData extractMealData(JsonNode row, int mealType) {
        String dateStr = row.path("MLSV_YMD").asText();
        String dishName = row.path("DDISH_NM").asText();
        String calInfo = row.path("CAL_INFO").asText().replace("Kcal", "").trim();

        List<String> menus = Arrays.stream(dishName.split("<br/>"))
                .filter(menu -> !menu.trim().isEmpty())
                .collect(Collectors.toList());

        Date date = java.sql.Date.valueOf(LocalDate.parse(dateStr, DATE_FORMATTER));
        float calories = parseCalories(calInfo);
        String type = MEAL_TYPE_MAP.getOrDefault(mealType, "UNKNOWN");

        return new MealData(date, type, calories, menus);
    }

    private float parseCalories(String calInfo) {
        try {
            return Float.parseFloat(calInfo);
        } catch (NumberFormatException e) {
            log.warn("칼로리 정보 파싱 실패: {}", calInfo);
            return 0.0f;
        }
    }

    private void processMenu(Meal meal, String rawMenu) {
        List<Long> allergyIds = extractAllergyIds(rawMenu);
        String menuName = cleanMenuName(rawMenu);

        if (menuName.isEmpty()) {
            return;
        }

        Menu menu = menuService.findByName(menuName)
                .orElseGet(() -> menuService.save(menuName));

        saveAllergyMappings(menu.getMenuId(), allergyIds);
        saveMealMenuMapping(meal, menu);
    }

    private List<Long> extractAllergyIds(String rawMenu) {
        Matcher matcher = ALLERGY_PATTERN.matcher(rawMenu);
        if (!matcher.find()) {
            return Collections.emptyList();
        }

        return Arrays.stream(matcher.group(1).split("\\."))
                .map(this::parseAllergyId)
                .filter(Objects::nonNull)
                .filter(id -> id <= MAX_ALLERGY_ID)
                .collect(Collectors.toList());
    }

    private Long parseAllergyId(String allergyStr) {
        try {
            return Long.parseLong(allergyStr);
        } catch (NumberFormatException e) {
            log.warn("알러지 ID 파싱 실패: {}", allergyStr);
            return null;
        }
    }

    private String cleanMenuName(String rawMenu) {
        return rawMenu.replaceAll("\\(.*?\\)", "").trim();
    }

    private void saveAllergyMappings(Long menuId, List<Long> allergyIds) {
        allergyIds.forEach(allergyId -> menuAllergyService.save(menuId, allergyId));
    }

    private void saveMealMenuMapping(Meal meal, Menu menu) {
        MealMenu mealMenu = MealMenu.builder()
                .meal(meal)
                .menu(menu)
                .build();
        mealMenuRepository.save(mealMenu);
    }


    // Record classes for better data modeling
    private record DateRange(String from, String to) {
    }

    private record MealData(Date date, String type, float calories, List<String> menus) {
    }
}