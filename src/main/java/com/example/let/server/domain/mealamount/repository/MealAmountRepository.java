package com.example.let.server.domain.mealamount.repository;

import com.example.let.server.domain.mealamount.domain.MealAmount;

import java.util.List;

public interface MealAmountRepository {
    void save(MealAmount mealAmount);
    List<MealAmount> findAll();
    List<MealAmount> findByMealId(Integer mealId);
}
