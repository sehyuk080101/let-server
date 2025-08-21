package com.example.let.server.domain.mealrating.repository;

import com.example.let.server.domain.mealrating.domain.MealRating;

import java.util.List;

public interface MealRatingRepository {
    MealRating save(MealRating mealRating);
    
    List<MealRating> findByMeal_MealId(int mealId);
    
    Double getMonthlyAverageRating(int year, int month);
}
