package com.example.let_server.domain.mealMenu.controller;

import com.example.let_server.domain.meal.dto.response.MealResponse;
import com.example.let_server.domain.mealMenu.service.MealMenuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mealMenu")
@RequiredArgsConstructor
@Tag(name = "mealMenu", description = "급식 관련 API")
public class MealMenuController {
    private final MealMenuService mealMenuService;

    @GetMapping("/{period}")
    @Operation(summary = "현재 달의 급식 조회")
    public ResponseEntity<List<MealResponse>> getMonthlyMenu(
            @PathVariable String period,
            @Parameter(
                    description = "알러지 ID 리스트",
                    in = ParameterIn.QUERY,
                    required = false,
                    example = "1,2,5"
            )
            @RequestParam(required = false) List<Long> allergyIds
    ) {
        return ResponseEntity.ok(mealMenuService.getMonthlyMenu(period, allergyIds));
    }

    @GetMapping("/maxEater")
    @Operation(summary = "이번달 가장 많은 식사자를 가진 급식(아침/점심/저녁)")
    public ResponseEntity<List<MealResponse>> getMaxEatersPerMealType(){
        return ResponseEntity.ok(mealMenuService.getMaxEatersPerMealType());
    }
}