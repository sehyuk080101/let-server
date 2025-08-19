package com.example.let_server.domain.mealRating.controller;

import com.example.let_server.domain.mealRating.docs.MealRatingDocs;
import com.example.let_server.domain.mealRating.dto.request.MealRatingRequest;
import com.example.let_server.domain.mealRating.dto.response.MealRatingResponse;
import com.example.let_server.domain.mealRating.service.MealRatingService;
import com.example.let_server.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("meal-rating")
public class MealRatingController implements MealRatingDocs {
    private final MealRatingService mealRatingService;

    @PostMapping
    @Override
    public ResponseEntity<BaseResponse<MealRatingResponse>> saveMealRating(@RequestBody MealRatingRequest mealRatingRequest) {
        return BaseResponse.of(mealRatingService.saveMealRating(mealRatingRequest), 201);
    }

    @GetMapping("/meal/{mealId}")
    @Override
    public ResponseEntity<BaseResponse<List<MealRatingResponse>>> getMealRatingsByMealId(@PathVariable("mealId") int mealId) {
        List<MealRatingResponse> ratings = mealRatingService.getMealRatingsByMealId(mealId);
        return BaseResponse.of(ratings);
    }

    @GetMapping("/statistics/{mealId}")
    @Override
    public ResponseEntity<BaseResponse<Double>> getMealRatingAverage(@PathVariable("mealId") int mealId) {
        Double avgRating = mealRatingService.getAverageRatingByMealId(mealId);
        return BaseResponse.of(avgRating);
    }

    @GetMapping("/monthly/{year}/{month}")
    @Override
    public ResponseEntity<BaseResponse<Double>> getMonthlyAverageRating(
            @PathVariable("year") int year,
            @PathVariable("month") int month) {
        Double avgRating = mealRatingService.getMonthlyAverageRating(year, month);
        return BaseResponse.of(avgRating);
    }
}
