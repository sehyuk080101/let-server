package com.example.let_server.domain.mealRating.docs;

import com.example.let_server.domain.mealRating.dto.request.MealRatingRequest;
import com.example.let_server.domain.mealRating.dto.response.MealRatingResponse;
import com.example.let_server.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "meal-rating", description = "급식 점수 관련 API")
public interface MealRatingDocs {
    @Operation(summary = "급식 평점 지정")
    ResponseEntity<BaseResponse<MealRatingResponse>> saveMealRating(@RequestBody MealRatingRequest mealRatingRequest);
}