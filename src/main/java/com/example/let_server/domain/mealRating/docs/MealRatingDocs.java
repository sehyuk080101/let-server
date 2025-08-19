package com.example.let_server.domain.mealRating.docs;

import com.example.let_server.domain.mealRating.dto.request.MealRatingRequest;
import com.example.let_server.domain.mealRating.dto.response.MealRatingResponse;
import com.example.let_server.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "meal-rating", description = "급식 평점 관련 API")
public interface MealRatingDocs {
    
    @Operation(summary = "급식 평점 등록", description = "특정 급식에 대한 평점을 등록합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "평점 등록 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 데이터"),
            @ApiResponse(responseCode = "404", description = "급식을 찾을 수 없음"),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    ResponseEntity<BaseResponse<MealRatingResponse>> saveMealRating(
            @RequestBody MealRatingRequest mealRatingRequest
    );

    @Operation(summary = "급식별 평점 목록 조회", description = "특정 급식에 등록된 모든 평점을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "평점 목록 조회 성공"),
            @ApiResponse(responseCode = "404", description = "급식을 찾을 수 없음"),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    ResponseEntity<BaseResponse<List<MealRatingResponse>>> getMealRatingsByMealId(
            @Parameter(description = "급식 ID", example = "1")
            @PathVariable("mealId") int mealId
    );

    @Operation(summary = "급식 평균 평점 조회", description = "특정 급식의 평균 평점을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "평균 평점 조회 성공"),
            @ApiResponse(responseCode = "404", description = "급식을 찾을 수 없음"),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    ResponseEntity<BaseResponse<Double>> getMealRatingAverage(
            @Parameter(description = "급식 ID", example = "1")
            @PathVariable("mealId") int mealId
    );

    @Operation(summary = "월별 평균 평점 조회", description = "특정 년월의 급식 평균 평점을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "월별 평균 평점 조회 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 년도/월 형식"),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    ResponseEntity<BaseResponse<Double>> getMonthlyAverageRating(
            @Parameter(description = "조회할 년도", example = "2024")
            @PathVariable("year") int year,
            
            @Parameter(description = "조회할 월 (1-12)", example = "8")
            @PathVariable("month") int month
    );
}