package com.example.let_server.domain.mealRating.service;

import com.example.let_server.domain.meal.domain.Meal;
import com.example.let_server.domain.meal.service.MealService;
import com.example.let_server.domain.mealRating.domain.MealRating;
import com.example.let_server.domain.mealRating.dto.request.MealRatingRequest;
import com.example.let_server.domain.mealRating.dto.response.MealRatingResponse;
import com.example.let_server.domain.mealRating.repository.MealRatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<MealRatingResponse> getMealRatingsByMealId(int mealId) {
        List<MealRating> ratings = mealRatingRepository.findByMeal_MealId(mealId);
        return ratings.stream()
                .map(MealRatingResponse::of)
                .collect(Collectors.toList());
    }

    @Override
    public Double getAverageRatingByMealId(int mealId) {
        List<MealRating> ratings = mealRatingRepository.findByMeal_MealId(mealId);
        if (ratings.isEmpty()) {
            return 0.0;
        }
        double sum = ratings.stream()
                .mapToDouble(MealRating::getRating)
                .sum();
        return sum / ratings.size();
    }

    @Override
    public Double getMonthlyAverageRating(int year, int month) {
        // 해당 년월의 모든 급식 평점 평균 계산
        return mealRatingRepository.getMonthlyAverageRating(year, month);
    }

}
