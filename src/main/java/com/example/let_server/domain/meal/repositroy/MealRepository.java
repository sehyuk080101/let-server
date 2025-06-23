package com.example.let_server.domain.meal.repositroy;

import com.example.let_server.domain.meal.domain.Meal;
import com.example.let_server.domain.meal.domain.MealType;

import java.util.Date;
import java.util.Optional;

public interface MealRepository {
    Meal save(Meal meal);
    Optional<Meal> findById(Integer mealId);
    Optional<Meal> findByMealTypeAndMealDate(MealType mealType, Date mealDate);
}
