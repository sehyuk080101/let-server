package com.example.let.server.domain.mealamount.controller;

import com.example.let.server.domain.mealamount.docs.MealAmountDocs;
import com.example.let.server.domain.mealamount.domain.MealAmount;
import com.example.let.server.domain.mealamount.dto.request.MealAmountRequest;
import com.example.let.server.domain.mealamount.service.MealAmountService;
import com.example.let.server.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/meal-amount")
public class MealAmountController implements MealAmountDocs {
    private final MealAmountService mealAmountService;

    @Override
    @PostMapping
    public ResponseEntity<BaseResponse<Void>> saveMealAmount(@RequestBody MealAmountRequest request) {
        mealAmountService.saveMealAmount(request);
        return BaseResponse.of(null, HttpStatus.CREATED.value());
    }

    @Override
    @GetMapping("/{mealId}")
    public ResponseEntity<BaseResponse<List<MealAmount>>> findMealAmountsByMealId(@PathVariable Integer mealId) {
        List<MealAmount> mealAmounts = mealAmountService.findMealAmountsByMealId(mealId);
        return BaseResponse.of(mealAmounts, HttpStatus.OK.value());
    }

    @Override
    @GetMapping
    public ResponseEntity<BaseResponse<List<MealAmount>>> findAllMealAmounts() {
        List<MealAmount> mealAmounts = mealAmountService.findAllMealAmounts();
        return BaseResponse.of(mealAmounts, HttpStatus.OK.value());
    }
}
