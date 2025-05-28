package com.example.let_server.domain.meal.repositroy;

import com.example.let_server.domain.meal.domain.Meal;

import java.util.Optional;

public interface MealRepository {
    Meal save(Meal meal);
    Optional<Meal> findById(Long mealId);
}
