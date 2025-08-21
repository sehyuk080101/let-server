package com.example.let.server.domain.mealrating.controller;

import com.example.let.server.domain.mealrating.docs.MealRatingDocs;
import com.example.let.server.domain.mealrating.dto.request.MealRatingRequest;
import com.example.let.server.domain.mealrating.dto.response.MealRatingResponse;
import com.example.let.server.domain.mealrating.service.MealRatingService;
import com.example.let.server.global.common.BaseResponse;
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
        return BaseResponse.of(mealRatingService.saveMealRating(mealRatingRequest), HttpStatus.CREATED.value());
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
