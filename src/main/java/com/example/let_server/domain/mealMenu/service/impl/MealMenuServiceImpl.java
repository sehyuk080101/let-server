package com.example.let_server.domain.mealMenu.service.impl;

import com.example.let_server.domain.meal.domain.Meal;
import com.example.let_server.domain.meal.dto.response.MealResponse;
import com.example.let_server.domain.meal.service.MealService;
import com.example.let_server.domain.mealMenu.domain.MealMenu;
import com.example.let_server.domain.mealMenu.repository.MealMenuRepository;
import com.example.let_server.domain.mealMenu.service.MealMenuService;
import com.example.let_server.domain.menu.domain.Menu;
import com.example.let_server.domain.menu.dto.MenuResponse;
import com.example.let_server.domain.menu.service.MenuService;
import com.example.let_server.domain.menuAllergy.service.MenuAllergyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class MealMenuServiceImpl implements MealMenuService {
    private final MealMenuRepository mealMenuRepository;
    private final RestTemplate restTemplate;
    private final MealService mealService;
    private final MenuAllergyService menuAllergyService;


    @Value("${KEY}")
    private String KEY;
    private final MenuService menuService;

//    @PostConstruct
//    public void init() {
//        fetchAndSaveMonthlyMeals();
//    }

    @Scheduled(cron = "0 0 0 1 * ?")
    public void fetchAndSaveMonthlyMeals() {
        LocalDate now = LocalDate.now();
        String from = now.withDayOfMonth(1).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String to = now.withDayOfMonth(now.lengthOfMonth()).format(DateTimeFormatter.ofPattern("yyyyMMdd"));


        for (int mealType = 1; mealType <= 3; mealType++) {
            String url = String.format(
                    "https://open.neis.go.kr/hub/mealServiceDietInfo?ATPT_OFCDC_SC_CODE=D10&SD_SCHUL_CODE=7240454&KEY=%s&MLSV_FROM_YMD=%s&MLSV_TO_YMD=%s&Type=json&MMEAL_SC_CODE=%d&pSize=100",KEY,from,to,mealType
            );

            try {
                ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
                if (response.getStatusCode().is2xxSuccessful()) {
                    parseAndSave(response.getBody(),mealType);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<MealResponse> getMonthlyMenu(String period,Long allergyId) {
        String yearMonth = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM"));
        List<MealMenu> mealMenus = mealMenuRepository.findMonthlyMealMenu(yearMonth,period, allergyId);

        Map<Integer, MealResponse> mealMap = new LinkedHashMap<>();

        for (MealMenu mm : mealMenus) {
            Meal meal = mm.getMeal();
            Menu menu = mm.getMenu();

            MealResponse mealResponse = mealMap.get(meal.getMealId());
            if (mealResponse == null) {
                mealResponse = MealResponse.of(meal);
                mealMap.put(meal.getMealId(), mealResponse);
            }

            mealResponse.getMenus().add(MenuResponse.of(menu));
        }
        return new ArrayList<>(mealMap.values());
    }

    private void parseAndSave(String json, int mealType) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(json);

        JsonNode rows = root.path("mealServiceDietInfo").path(1).path("row");
        if (rows.isMissingNode()) return;

        for (JsonNode row : rows) {
            String dateStr = row.path("MLSV_YMD").asText();
            String dishName = row.path("DDISH_NM").asText();
            String calInfo = row.path("CAL_INFO").asText().replace("Kcal", "").trim();

            List<String> menus = Arrays.stream(dishName.split("<br/>"))
                    .filter(s -> !s.isEmpty())
                    .toList();

            Date date = java.sql.Date.valueOf(LocalDate.parse(dateStr,DateTimeFormatter.ofPattern("yyyyMMdd")));
            float calories = Float.parseFloat(calInfo);

            String type = switch (mealType){
                case 1 -> "조식";
                case 2 -> "중식";
                case 3 -> "석식";
                default -> "UNKNOWN";
            };

            Meal meal = mealService.createMeal(date,type,calories);

            for (String rawMenu : menus) {
                Matcher matcher = Pattern.compile("\\((\\d+(?:\\.\\d+)*)\\)").matcher(rawMenu);
                List<Long> allergyIds = new ArrayList<>();
                if (matcher.find()) {
                    String[] allergyStrs = matcher.group(1).split("\\.");
                    for (String s : allergyStrs) {
                        try {
                            Long allergyId = Long.parseLong(s);
                            if (allergyId <= 19)
                                allergyIds.add(allergyId);
                        } catch (NumberFormatException ignored) {}
                    }
                }

                // 괄호(알러지) 제거 → 메뉴 이름 추출
                String menuName = rawMenu.replaceAll("\\(.*?\\)", "").trim();
                if (menuName.isEmpty()) continue;

                // 메뉴 저장
                Menu menu = menuService.save(menuName);

                // 알러지 매핑
                for (Long allergyId : allergyIds) {
                    menuAllergyService.save(menu.getMenuId(), allergyId);
                }

                // 급식-메뉴 매핑 저장
                mealMenuRepository.save(MealMenu.builder()
                        .meal(meal)
                        .menu(menu)
                        .build());
            }

        }
    }

}
