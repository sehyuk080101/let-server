package com.example.let_server.domain.mealMenu.service.impl;

import com.example.let_server.domain.meal.domain.Meal;
import com.example.let_server.domain.meal.service.MealService;
import com.example.let_server.domain.mealMenu.domain.MealMenu;
import com.example.let_server.domain.mealMenu.dto.response.MealMenuResponse;
import com.example.let_server.domain.mealMenu.mapper.MealMenuMapper;
import com.example.let_server.domain.mealMenu.repository.MealMenuRepository;
import com.example.let_server.domain.mealMenu.service.MealMenuService;
import com.example.let_server.domain.menu.domain.Menu;
import com.example.let_server.domain.menu.service.MenuService;
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
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MealMenuServiceImpl implements MealMenuService {
    private final MealMenuRepository mealMenuRepository;
    private final RestTemplate restTemplate;
    private final MealService mealService;
    private final MealMenuMapper mealMenuMapper;


    @Value("${KEY}")
    private String KEY;
    private final MenuService menuService;

    @PostConstruct
    public void init() {
        fetchAndSaveMonthlyMeals();
    }

    @Scheduled(cron = "0 0 0 1 * ?")
    @Override
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
    public List<MealMenuResponse> getMonthlyMenu() {
        String yearMonth = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM"));
        return mealMenuMapper.findMonthlyMealMenu(yearMonth).stream().map(MealMenuResponse::of).toList();
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
                    .map(s -> s.replaceAll("\\(.*?\\)", "").trim()) // 괄호 제거
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
            for (String menuName : menus){
                Menu menu = menuService.save(menuName);
                mealMenuRepository.save(MealMenu.builder()
                                .meal(meal)
                                .menu(menu)
                        .build());
            }

        }
    }

}
