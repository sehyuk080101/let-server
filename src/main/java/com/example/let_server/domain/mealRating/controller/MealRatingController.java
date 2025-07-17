package com.example.let_server.domain.mealRating.controller;

import com.example.let_server.domain.mealRating.docs.MealRatingDocs;
import com.example.let_server.domain.mealRating.dto.request.MealRatingRequest;
import com.example.let_server.domain.mealRating.dto.response.MealRatingResponse;
import com.example.let_server.domain.mealRating.service.MealRatingService;
import com.example.let_server.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
