package com.example.let_server.domain.meal.repositroy;

import com.example.let_server.domain.meal.domain.Meal;
import com.example.let_server.domain.meal.mapper.MealMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MybatisMealRepository implements MealRepository{

    private final MealMapper mealMapper;

    @Override
    public Meal save(Meal meal) {
        mealMapper.save(meal);
        return meal;
    }
}
