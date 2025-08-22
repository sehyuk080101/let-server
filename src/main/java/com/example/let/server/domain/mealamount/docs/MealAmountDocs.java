package com.example.let.server.domain.mealamount.docs;

import com.example.let.server.domain.mealamount.domain.MealAmount;
import com.example.let.server.domain.mealamount.dto.request.MealAmountRequest;
import com.example.let.server.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "meal-amount", description = "급식 양 평가")
public interface MealAmountDocs {
    @Operation(
            summary = "급식 양 평가 저장"
    )
    ResponseEntity<BaseResponse<Void>> saveMealAmount(MealAmountRequest request);

    @Operation(
            summary = "모든 급식 양 평가 불러오기"
    )
    ResponseEntity<BaseResponse<List<MealAmount>>> findAllMealAmounts();

    @Operation(
            summary = "특정 급식의 급식 양 평가 불러오기"
    )
    ResponseEntity<BaseResponse<List<MealAmount>>> findMealAmountsByMealId(Integer mealId);
}
