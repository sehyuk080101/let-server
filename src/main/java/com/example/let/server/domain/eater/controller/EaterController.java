package com.example.let.server.domain.eater.controller;

import com.example.let.server.domain.eater.docs.EaterDocs;
import com.example.let.server.domain.eater.dto.response.EaterRatioResponse;
import com.example.let.server.domain.eater.dto.response.EaterResponse;
import com.example.let.server.domain.eater.dto.response.UserCalorieResponse;
import com.example.let.server.domain.eater.service.EaterService;
import com.example.let.server.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/eater")
public class EaterController implements EaterDocs {
    private final EaterService eaterService;

    @GetMapping("/{grade}")
    @Override
    public ResponseEntity<BaseResponse<List<EaterResponse>>> getByGrade(@PathVariable Long grade) {
        return BaseResponse.of(eaterService.findByGrade(grade));
    }

    @GetMapping("/meal-rate")
    @Override
    public ResponseEntity<BaseResponse<List<EaterRatioResponse>>> getMealRateByGrade(
            @RequestParam(required = false) String mealType) {
        return BaseResponse.of(eaterService.getEaterRation(mealType));
    }

    @GetMapping("/not-eaten")
    @Override
    public ResponseEntity<BaseResponse<Integer>> getNotEaterCount() {
        return BaseResponse.of(eaterService.getNotEaterCount());
    }

    @GetMapping("/month/meal-rate")
    @Override
    public ResponseEntity<BaseResponse<List<EaterRatioResponse>>> getMealRateByMonth(){
        return BaseResponse.of(eaterService.getEaterRationMonthly());
    }

    @GetMapping("/month/meal-rate/all")
    @Override
    public ResponseEntity<BaseResponse<List<EaterRatioResponse>>> getAllMealRateByMonth(){
        return BaseResponse.of(eaterService.getAllEaterRationMonthly());
    }

    @GetMapping("/user/{userId}/date/{date}")
    @Override
    public ResponseEntity<BaseResponse<UserCalorieResponse>> getUserEatenMeals(
            @PathVariable Long userId, 
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return BaseResponse.of(eaterService.getUserCalorieIntake(userId, date));
    }

    @PatchMapping
    @Override
    public ResponseEntity<BaseResponse<Void>> registerEater() {
        eaterService.registerEater();
        return BaseResponse.of(null, HttpStatus.NO_CONTENT.value());
    }

    @GetMapping("/server-time")
    public String getServerTime() {
        return LocalDateTime.now().toString();
    }

}
