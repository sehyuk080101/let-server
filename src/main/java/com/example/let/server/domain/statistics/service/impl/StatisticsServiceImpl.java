package com.example.let.server.domain.statistics.service.impl;

import com.example.let.server.domain.eater.service.EaterService;
import com.example.let.server.domain.mealrating.service.MealRatingService;
import com.example.let.server.domain.menurank.service.MenuRankService;
import com.example.let.server.domain.meal.service.MealService;
import com.example.let.server.domain.statistics.dto.response.MonthlyStatisticsResponse;
import com.example.let.server.domain.statistics.dto.response.MealStatistics;
import com.example.let.server.domain.statistics.dto.response.LowParticipationAnalysis;
import com.example.let.server.domain.statistics.dto.response.LowParticipationMeal;
import com.example.let.server.domain.statistics.dto.response.MealDetails;
import com.example.let.server.domain.statistics.service.StatisticsService;
import com.example.let.server.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticsServiceImpl implements StatisticsService {
    private final UserService userService;
    private final MealRatingService mealRatingService;
    private final MenuRankService menuRankService;
    private final EaterService eaterService;
    private final MealService mealService;

    @Override
    public MonthlyStatisticsResponse getMonthlyStatistics(int year, int month) {
        // 사용자 통계
        Long totalStudents = userService.getTotalUserCount();
        var studentsByGrade = userService.getUserCountByGrade();
        
        // 평점 통계
        Double averageRating = mealRatingService.getMonthlyAverageRating(year, month);
        if (averageRating == null) averageRating = 0.0;
        
        // 메뉴 순위 (상위 5개, 하위 5개)
        var menuRanks = menuRankService.getMenuRankings();
        List<String> topMenus = menuRanks.stream()
                .limit(5)
                .map(menu -> menu.getMenuName())
                .toList();
        
        List<String> leastPopularMenus = menuRanks.stream()
                .skip(Math.max(0, menuRanks.size() - 5))
                .map(menu -> menu.getMenuName())
                .toList();
        
        // 실제 계산된 통계값들
        Double participationRate = eaterService.getMonthlyParticipationRate(year, month);
        if (participationRate == null) participationRate = 0.0;
        
        Long totalMeals = mealService.getMonthlyMealCount(year, month);
        if (totalMeals == null) totalMeals = 0L;
        
        Double totalCaloriesProvided = mealService.getMonthlyTotalCalories(year, month);
        if (totalCaloriesProvided == null) totalCaloriesProvided = 0.0;
        
        Double totalCaloriesConsumed = eaterService.getMonthlyTotalCaloriesConsumed(year, month);
        if (totalCaloriesConsumed == null) totalCaloriesConsumed = 0.0;

        return MonthlyStatisticsResponse.builder()
                .year(year)
                .month(month)
                .totalStudents(totalStudents)
                .studentsByGrade(studentsByGrade)
                .averageParticipationRate(participationRate)
                .averageRating(averageRating)
                .totalMeals(totalMeals)
                .totalCaloriesProvided(totalCaloriesProvided)
                .totalCaloriesConsumed(totalCaloriesConsumed)
                .topMenus(topMenus)
                .leastPopularMenus(leastPopularMenus)
                .build();
    }

    @Override
    public MealStatistics getMealStatistics(Long mealId) {
        return mealService.getMealStatistics(mealId);
    }

    @Override
    public LowParticipationAnalysis getLowParticipationMeals(int threshold, String period) {
        List<LowParticipationMeal> lowParticipationMeals = mealService.findLowParticipationMeals(threshold, period);
        
        return LowParticipationAnalysis.builder()
                .threshold(threshold)
                .period(period)
                .count(lowParticipationMeals.size())
                .lowParticipationMeals(lowParticipationMeals)
                .build();
    }

    @Override
    public MealDetails getMealDetails(Long mealId) {
        return mealService.getMealDetails(mealId);
    }
}