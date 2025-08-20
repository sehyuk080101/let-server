package com.example.let.server.domain.statistics.controller;

import com.example.let.server.domain.statistics.docs.StatisticsDocs;
import com.example.let.server.domain.statistics.dto.response.MonthlyStatisticsResponse;
import com.example.let.server.domain.statistics.dto.response.MealStatistics;
import com.example.let.server.domain.statistics.dto.response.LowParticipationAnalysis;
import com.example.let.server.domain.statistics.dto.response.MealDetails;
import com.example.let.server.domain.statistics.service.StatisticsService;
import com.example.let.server.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/statistics")
@RequiredArgsConstructor
public class StatisticsController implements StatisticsDocs {
    private final StatisticsService statisticsService;

    @GetMapping("/monthly/{year}/{month}")
    public ResponseEntity<BaseResponse<MonthlyStatisticsResponse>> getMonthlyStatistics(
            @PathVariable("year") int year,
            @PathVariable("month") int month) {
        MonthlyStatisticsResponse statistics = statisticsService.getMonthlyStatistics(year, month);
        return BaseResponse.of(statistics);
    }

    @GetMapping("/meal/{mealId}/statistics")
    public ResponseEntity<BaseResponse<MealStatistics>> getMealStatistics(
            @PathVariable("mealId") Long mealId) {
        MealStatistics statistics = statisticsService.getMealStatistics(mealId);
        return BaseResponse.of(statistics);
    }

    @GetMapping("/meal/analysis/low-participation")
    public ResponseEntity<BaseResponse<LowParticipationAnalysis>> getLowParticipationMeals(
            @RequestParam(value = "threshold", defaultValue = "50") int threshold,
            @RequestParam("period") String period) {
        LowParticipationAnalysis analysis = statisticsService.getLowParticipationMeals(threshold, period);
        return BaseResponse.of(analysis);
    }

    @GetMapping("/meal/{mealId}/details")
    public ResponseEntity<BaseResponse<MealDetails>> getMealDetails(
            @PathVariable("mealId") Long mealId) {
        MealDetails details = statisticsService.getMealDetails(mealId);
        return BaseResponse.of(details);
    }
}
