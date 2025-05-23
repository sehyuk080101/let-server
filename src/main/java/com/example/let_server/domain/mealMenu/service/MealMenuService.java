package com.example.let_server.domain.mealMenu.service;

import com.example.let_server.domain.mealMenu.dto.response.MealMenuResponse;

import java.util.List;

public interface MealMenuService {
    void fetchAndSaveMonthlyMeals();
    List<MealMenuResponse> getMonthlyMenu();
}
