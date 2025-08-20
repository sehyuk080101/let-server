package com.example.let.server.domain.statistics.docs;

import com.example.let.server.domain.statistics.dto.response.MonthlyStatisticsResponse;
import com.example.let.server.domain.statistics.dto.response.MealStatistics;
import com.example.let.server.domain.statistics.dto.response.LowParticipationAnalysis;
import com.example.let.server.domain.statistics.dto.response.MealDetails;
import com.example.let.server.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "통계", description = "급식 관련 월별 통계 API")
public interface StatisticsDocs {

    @Operation(summary = "월별 급식 통계 조회", description = "지정된 년월의 급식 통계를 조회합니다. (사용자 수, 참여율, 평점, 칼로리 등)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "통계 조회 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 (년도/월 형식 오류)"),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    ResponseEntity<BaseResponse<MonthlyStatisticsResponse>> getMonthlyStatistics(
            @Parameter(description = "조회할 년도 (예: 2024)", example = "2024")
            @PathVariable("year") int year,
            
            @Parameter(description = "조회할 월 (1-12)", example = "8")
            @PathVariable("month") int month
    );

    @Operation(summary = "개별 급식 통계 조회", description = "특정 급식의 상세 통계를 조회합니다. (참여율, 평점, 칼로리 등)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "급식 통계 조회 성공"),
            @ApiResponse(responseCode = "404", description = "급식을 찾을 수 없음"),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    ResponseEntity<BaseResponse<MealStatistics>> getMealStatistics(
            @Parameter(description = "급식 ID", example = "123")
            @PathVariable("mealId") Long mealId
    );

    @Operation(summary = "저참여율 급식 분석", description = "지정된 기간 내 참여율이 임계값보다 낮은 급식들을 분석합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "저참여율 급식 분석 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 파라미터"),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    ResponseEntity<BaseResponse<LowParticipationAnalysis>> getLowParticipationMeals(
            @Parameter(description = "참여율 임계값 (%)", example = "50")
            @RequestParam(value = "threshold", defaultValue = "50") int threshold,
            
            @Parameter(description = "조회 기간 (YYYY-MM)", example = "2024-11")
            @RequestParam("period") String period
    );

    @Operation(summary = "급식 상세 정보 조회", description = "급식 ID로 급식의 상세 정보를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "급식 상세 정보 조회 성공"),
            @ApiResponse(responseCode = "404", description = "급식을 찾을 수 없음"),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    ResponseEntity<BaseResponse<MealDetails>> getMealDetails(
            @Parameter(description = "급식 ID", example = "123")
            @PathVariable("mealId") Long mealId
    );
}