package com.example.let.server.domain.mealrating.service;


import com.example.let.server.domain.mealrating.dto.request.MealRatingRequest;
import com.example.let.server.domain.mealrating.dto.response.MealRatingResponse;

import java.util.List;

public interface MealRatingService {
    MealRatingResponse saveMealRating(MealRatingRequest request);

    List<MealRatingResponse> getMealRatingsByMealId(int mealId);

    Double getAverageRatingByMealId(int mealId);

    Double getMonthlyAverageRating(int year, int month);
}
