package com.example.let_server.domain.statistics.service;

import com.example.let_server.domain.statistics.dto.response.MonthlyStatisticsResponse;
import com.example.let_server.domain.statistics.dto.response.MealStatistics;
import com.example.let_server.domain.statistics.dto.response.LowParticipationAnalysis;
import com.example.let_server.domain.statistics.dto.response.MealDetails;

public interface StatisticsService {
    MonthlyStatisticsResponse getMonthlyStatistics(int year, int month);
    MealStatistics getMealStatistics(Long mealId);
    LowParticipationAnalysis getLowParticipationMeals(int threshold, String period);
    MealDetails getMealDetails(Long mealId);
}