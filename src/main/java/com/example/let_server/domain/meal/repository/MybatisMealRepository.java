package com.example.let_server.domain.meal.repository;

import com.example.let_server.domain.meal.domain.Meal;
import com.example.let_server.domain.meal.domain.MealType;
import com.example.let_server.domain.meal.mapper.MealMapper;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.Optional;

@RequiredArgsConstructor
public class MybatisMealRepository implements MealRepository {

    private final MealMapper mealMapper;

    @Override
    public Meal save(Meal meal) {
        mealMapper.save(meal);
        return meal;
    }

    @Override
    public Optional<Meal> findById(Integer mealId) {
        return mealMapper.findById(mealId);
    }

    @Override
    public Optional<Meal> findByMealTypeAndMealDate(MealType mealType, Date mealDate) {
        return mealMapper.findByMealTypeAndMealDate(mealType, mealDate);
    }
}
