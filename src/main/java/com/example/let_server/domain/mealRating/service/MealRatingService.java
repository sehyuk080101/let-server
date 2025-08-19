package com.example.let_server.domain.mealRating.service;


import com.example.let_server.domain.mealRating.dto.request.MealRatingRequest;
import com.example.let_server.domain.mealRating.dto.response.MealRatingResponse;

import java.util.List;

public interface MealRatingService {
    MealRatingResponse saveMealRating(MealRatingRequest request);
    List<MealRatingResponse> getMealRatingsByMealId(int mealId);
    Double getAverageRatingByMealId(int mealId);
    Double getMonthlyAverageRating(int year, int month);
}
