package com.example.let_server.domain.mealMenu.repository;

import com.example.let_server.domain.mealMenu.domain.MealMenu;

import java.util.List;

public interface MealMenuRepository {
    MealMenu save(MealMenu mealMenu);
    List<MealMenu> findMonthlyMealMenu(String yearMonth);
}
