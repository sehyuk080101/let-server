package com.example.let_server.domain.meal.repositroy;

import com.example.let_server.domain.meal.domain.Meal;

public interface MealRepository  {
    Meal save(Meal meal);
}
