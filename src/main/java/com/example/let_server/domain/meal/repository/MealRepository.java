package com.example.let_server.domain.meal.repository;

import com.example.let_server.domain.meal.domain.Meal;
import com.example.let_server.domain.meal.domain.MealType;
import com.example.let_server.domain.statistics.dto.response.LowParticipationMeal;
import com.example.let_server.domain.statistics.dto.response.MealStatistics;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface MealRepository {
    Meal save(Meal meal);
    Optional<Meal> findById(Integer mealId);
    Optional<Meal> findByMealTypeAndMealDate(MealType mealType, Date mealDate);
    List<Meal> findByMealDate(Date mealDate);
    Long countByYearAndMonth(int year, int month);
    Double sumCaloriesByYearAndMonth(int year, int month);
    
    // 새로운 통계 관련 메서드들
    MealStatistics getMealStatistics(Long mealId);
    List<LowParticipationMeal> findLowParticipationMeals(int threshold, String period);
}
