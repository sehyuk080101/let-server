package com.example.let_server.domain.mealMenu.controller;

import com.example.let_server.domain.meal.dto.response.MealResponse;
import com.example.let_server.domain.mealMenu.dto.response.MealMenuResponse;
import com.example.let_server.domain.mealMenu.service.MealMenuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mealMenu")
@RequiredArgsConstructor
@Tag(name = "mealMenu", description = "급식 관련 API")
public class MealMenuController {
    private final MealMenuService mealMenuService;

    @GetMapping
    @Operation(
            summary = "현재 달의 급식 조회"
    )
    public ResponseEntity<List<MealResponse>> getMonthlyMenu(){
        return ResponseEntity.ok(mealMenuService.getMonthlyMenu()) ;
    }
}
