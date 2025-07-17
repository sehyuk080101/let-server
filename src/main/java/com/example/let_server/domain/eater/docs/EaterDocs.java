package com.example.let_server.domain.eater.docs;

import com.example.let_server.domain.eater.dto.response.EaterRatioResponse;
import com.example.let_server.domain.eater.dto.response.EaterResponse;
import com.example.let_server.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Tag(name = "eater", description = "식사자 관련 API")
public interface EaterDocs {
    @Operation(summary = "학년별 식사자 조회")
    ResponseEntity<BaseResponse<List<EaterResponse>>> getByGrade(@PathVariable Long grade);

    @Operation(summary = "학년별 식사자 비율 조회")
    ResponseEntity<BaseResponse<List<EaterRatioResponse>>> getMealRateByGrade(
            @RequestParam(required = false) String mealType);

    @Operation(summary = "현재 식사하지 않은 사람 수 조회")
    ResponseEntity<BaseResponse<Integer>> getNotEaterCount();

    @Operation(summary = "이번달 식사자 비율 조회")
    ResponseEntity<BaseResponse<List<EaterRatioResponse>>> getMealRateByMonth();
}