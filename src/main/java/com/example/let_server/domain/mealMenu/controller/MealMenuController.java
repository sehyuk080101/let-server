package com.example.let_server.domain.mealMenu.controller;

import com.example.let_server.domain.meal.dto.response.MaxEatersMealWithCountResponse;
import com.example.let_server.domain.meal.dto.response.MealDailyResponse;
import com.example.let_server.domain.meal.dto.response.MealResponse;
import com.example.let_server.domain.mealMenu.docs.MealMenuDocs;
import com.example.let_server.domain.mealMenu.service.MealMenuService;
import com.example.let_server.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/mealMenu")
@RequiredArgsConstructor
public class MealMenuController implements MealMenuDocs {
    private final MealMenuService mealMenuService;

    @GetMapping("/{period}")
    @Override
    public ResponseEntity<BaseResponse<List<MealResponse>>> getMonthlyMenu(
            @PathVariable String period,
            @Parameter(
                    description = "알러지 ID 리스트",
                    in = ParameterIn.QUERY,
                    required = false,
                    example = "1,2,5"
            )
            @RequestParam(required = false) List<Long> allergyIds
    ) {
        return BaseResponse.of(mealMenuService.getMonthlyMenu(period, allergyIds));
    }

    @GetMapping("/max-eater")
    @Override
    public ResponseEntity<BaseResponse<List<MaxEatersMealWithCountResponse>>> getMaxEatersPerMealType(){
        return BaseResponse.of(mealMenuService.getMaxEatersPerMealType());
    }

    @GetMapping("/daily/{today}")
    @Override
    public ResponseEntity<BaseResponse<List<MealDailyResponse>>> getMealDaily(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date today
            ){
        return BaseResponse.of(mealMenuService.getMealDaily(today));
    }
}