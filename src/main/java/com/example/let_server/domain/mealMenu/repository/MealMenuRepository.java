package com.example.let_server.domain.mealMenu.repository;

import com.example.let_server.domain.meal.dto.response.MaxEatersMealWithCountResponse;
import com.example.let_server.domain.meal.dto.response.MealDailyResponse;
import com.example.let_server.domain.mealMenu.domain.MealMenu;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface MealMenuRepository {
    MealMenu save(MealMenu mealMenu);
    List<MealMenu> findMonthlyMealMenu(Map<String, Object> params);
    List<MaxEatersMealWithCountResponse> findMaxEatersPerMealType(int year, int month);
    List<MealDailyResponse> findMealDaily(Date today);

}
