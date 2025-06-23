package com.example.let_server.domain.mealRating.controller;

import com.example.let_server.domain.mealRating.dto.request.MealRatingRequest;
import com.example.let_server.domain.mealRating.dto.response.MealRatingResponse;
import com.example.let_server.domain.mealRating.service.MealRatingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "meal-rating", description = "급식 점수 관련 API")
public class MealRatingController {
    private final MealRatingService mealRatingService;

    @PostMapping
    @Operation(
            summary = "급식 평점 지정"
    )
    public ResponseEntity<MealRatingResponse> saveMealRating(@RequestBody MealRatingRequest mealRatingRequest) {
        return new ResponseEntity<>(mealRatingService.saveMealRating(mealRatingRequest), HttpStatus.CREATED);
    }
}
