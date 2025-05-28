package com.example.let_server.domain.mealMenu.service;

import com.example.let_server.domain.meal.dto.response.MealResponse;

import java.util.List;

public interface MealMenuService {
    List<MealResponse> getMonthlyMenu(String period, List<Long> allergyIds);
}
