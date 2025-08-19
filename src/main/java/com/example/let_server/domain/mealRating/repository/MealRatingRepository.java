package com.example.let_server.domain.mealRating.repository;

import com.example.let_server.domain.mealRating.domain.MealRating;

import java.util.List;

public interface MealRatingRepository {
    MealRating save(MealRating mealRating);
    
    List<MealRating> findByMeal_MealId(int mealId);
    
    Double getMonthlyAverageRating(int year, int month);
}
