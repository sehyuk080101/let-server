package com.example.let.server.domain.menuallergy.docs;

import com.example.let.server.domain.allergy.dto.response.AllergyResponse;
import com.example.let.server.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Tag(name = "menuAllergy", description = "알러지 관련 API")
public interface MenuAllergyDocs {
    @Operation(summary = "급식에 따른 알러지 검색")
    ResponseEntity<BaseResponse<List<AllergyResponse>>> getAllergyByMealId(@PathVariable("mealId") Integer mealId);
}