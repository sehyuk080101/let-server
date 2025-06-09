package com.example.let_server.domain.mealMenu.repository;

import com.example.let_server.domain.mealMenu.domain.MealMenu;

import java.util.List;
import java.util.Map;

public interface MealMenuRepository {
    MealMenu save(MealMenu mealMenu);

    List<MealMenu> findMonthlyMealMenu(Map<String, Object> params);
    List<MealMenu> findMaxEatersPerMealType(int year,int month);

}
