package com.example.let_server.domain.meal.service;

import com.example.let_server.domain.meal.domain.Meal;
import com.example.let_server.domain.meal.domain.MealType;
import com.example.let_server.domain.meal.error.MealError;
import com.example.let_server.domain.meal.repository.MealRepository;
import com.example.let_server.global.error.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class MealService {
    private final MealRepository mealRepository;

    public Meal createMeal(Date mealDate, String mealType, float calorie) {
        Meal meal = Meal.builder()
                .mealDate(mealDate)
                .mealType(MealType.valueOf(mealType))
                .calorie(calorie)
                .build();
        return mealRepository.save(meal);
    }

    public Meal getMealById(Integer mealId) {
        return mealRepository.findById(mealId)
                .orElseThrow(()->new CustomException(MealError.MEAL_NOT_FOUND));
    }

    public Meal getMealByMealTypeAndMealDate(MealType mealType, Date mealDate) {
        return mealRepository.findByMealTypeAndMealDate(mealType,mealDate)
                .orElseThrow(()->new CustomException(MealError.MEAL_NOT_FOUND));
    }
}
