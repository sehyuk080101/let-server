package com.example.let.server.domain.eater.docs;

import com.example.let.server.domain.eater.dto.response.EaterRatioResponse;
import com.example.let.server.domain.eater.dto.response.EaterResponse;
import com.example.let.server.domain.eater.dto.response.UserCalorieResponse;
import com.example.let.server.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "eater", description = "식사자 관련 API")
public interface EaterDocs {
    @Operation(summary = "학년별 식사자 조회", description = "특정 학년의 식사자 목록을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "식사자 조회 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 학년 (1-3 학년만 유효)"),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    ResponseEntity<BaseResponse<List<EaterResponse>>> getByGrade(
            @Parameter(description = "학년 (1, 2, 3)", example = "1")
            @PathVariable Long grade
    );

    @Operation(summary = "학년별 식사 참여율 조회", description = "학년별 식사 참여율을 조회합니다. 식사 타입을 지정하면 해당 식사의 참여율만 조회됩니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "참여율 조회 성공"),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    ResponseEntity<BaseResponse<List<EaterRatioResponse>>> getMealRateByGrade(
            @Parameter(description = "식사 타입 (조식, 중식, 석식)", example = "중식")
            @RequestParam(required = false) String mealType
    );

    @Operation(summary = "현재 미식사자 수 조회", description = "현재 식사 시간에 식사하지 않은 사람의 수를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "미식사자 수 조회 성공"),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    ResponseEntity<BaseResponse<Integer>> getNotEaterCount();

    @Operation(summary = "이번달 식사 참여율 조회", description = "이번달의 학년별 식사 참여율을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "월별 참여율 조회 성공"),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    ResponseEntity<BaseResponse<List<EaterRatioResponse>>> getMealRateByMonth();

    @Operation(summary = "이번달 전체 식사 타입별 참여율 조회", description = "이번달의 조식, 중식, 석식 모든 식사 타입별 학년별 참여율을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "전체 식사 타입별 참여율 조회 성공"),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    ResponseEntity<BaseResponse<List<EaterRatioResponse>>> getAllMealRateByMonth();

    @Operation(summary = "사용자별 일일 칼로리 섭취량 조회", description = "특정 사용자의 특정 날짜 칼로리 섭취량과 식사 정보를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "칼로리 섭취량 조회 성공"),
            @ApiResponse(responseCode = "404", description = "사용자를 찾을 수 없음"),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    ResponseEntity<BaseResponse<UserCalorieResponse>> getUserEatenMeals(
            @Parameter(description = "사용자 ID", example = "1")
            @PathVariable Long userId,

            @Parameter(description = "조회할 날짜 (yyyy-MM-dd 형식)", example = "2024-08-17")
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date
    );
}
