package com.example.let.server.domain.mealamount.service;

import com.example.let.server.domain.mealamount.domain.MealAmount;
import com.example.let.server.domain.mealamount.dto.request.MealAmountRequest;

import java.util.List;

public interface MealAmountService {
    void saveMealAmount(MealAmountRequest request);
    List<MealAmount> findAllMealAmounts();
    List<MealAmount> findMealAmountsByMealId(Integer mealId);
}
