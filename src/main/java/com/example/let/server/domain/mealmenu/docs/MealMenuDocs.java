package com.example.let.server.domain.mealmenu.docs;

import com.example.let.server.domain.meal.dto.response.MaxEatersMealWithCountResponse;
import com.example.let.server.domain.meal.dto.response.MealDailyResponse;
import com.example.let.server.domain.meal.dto.response.MealResponse;
import com.example.let.server.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Tag(name = "mealMenu", description = "급식 관련 API")
public interface MealMenuDocs {
    @Operation(summary = "현재 달의 급식 조회")
    ResponseEntity<BaseResponse<List<MealResponse>>> getMonthlyMenu(
            @PathVariable String period,
            @Parameter(
                    description = "알러지 ID 리스트",
                    in = ParameterIn.QUERY,
                    required = false,
                    example = "1,2,5"
            )
            @RequestParam(required = false) List<Long> allergyIds
    );

    @Operation(summary = "이번달 가장 많은 식사자를 가진 급식(아침/점심/저녁)")
    ResponseEntity<BaseResponse<List<MaxEatersMealWithCountResponse>>> getMaxEatersPerMealType();

    @Operation(summary = "하루치 급식 조회")
    ResponseEntity<BaseResponse<List<MealDailyResponse>>> getMealDaily(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date today
    );
}
