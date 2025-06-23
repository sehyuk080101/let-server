package com.example.let_server.domain.mealRating.service;

import com.example.let_server.domain.meal.domain.Meal;
import com.example.let_server.domain.meal.service.MealService;
import com.example.let_server.domain.mealRating.domain.MealRating;
import com.example.let_server.domain.mealRating.dto.request.MealRatingRequest;
import com.example.let_server.domain.mealRating.dto.response.MealRatingResponse;
import com.example.let_server.domain.mealRating.repository.MealRatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MealRatingServiceImpl implements MealRatingService {
    private final MealRatingRepository mealRatingRepository;
    private final MealService mealService;
    @Override
    public MealRatingResponse saveMealRating(MealRatingRequest request) {
        Meal meal = mealService.getMealById(request.getMealId());
        MealRating createdMealRating = MealRating.builder()
                .meal(meal)
                .rating(request.getRating())
                .build();
        return MealRatingResponse.of(mealRatingRepository.save(createdMealRating));
    }

}
