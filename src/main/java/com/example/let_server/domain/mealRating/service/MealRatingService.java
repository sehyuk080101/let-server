package com.example.let_server.domain.mealRating.service;


import com.example.let_server.domain.mealRating.dto.request.MealRatingRequest;
import com.example.let_server.domain.mealRating.dto.response.MealRatingResponse;

public interface MealRatingService {
    MealRatingResponse saveMealRating(MealRatingRequest request);
}
