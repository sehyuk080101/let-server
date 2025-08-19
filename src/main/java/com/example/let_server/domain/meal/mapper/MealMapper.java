package com.example.let_server.domain.meal.mapper;

import com.example.let_server.domain.meal.domain.Meal;
import com.example.let_server.domain.meal.domain.MealType;
import com.example.let_server.domain.statistics.dto.response.LowParticipationMeal;
import com.example.let_server.domain.statistics.dto.response.MealStatistics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Mapper
public interface MealMapper {
    void save(Meal meal);
    Optional<Meal> findById(Integer mealId);
    Optional<Meal> findByMealTypeAndMealDate(MealType mealType, Date mealDate);
    List<Meal> findByMealDate(Date mealDate);
    Long countByYearAndMonth(@Param("year") int year, @Param("month") int month);
    Double sumCaloriesByYearAndMonth(@Param("year") int year, @Param("month") int month);
    
    // 새로운 통계 관련 메서드들
    MealStatistics getMealStatistics(@Param("mealId") Long mealId);
    List<LowParticipationMeal> findLowParticipationMeals(@Param("threshold") int threshold, @Param("period") String period);
}
