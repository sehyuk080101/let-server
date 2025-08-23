package com.example.let.server.domain.eater.repository;

import com.example.let.server.domain.eater.domain.Eater;
import com.example.let.server.domain.eater.dto.response.EaterRatioResponse;
import com.example.let.server.domain.meal.domain.MealType;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EaterRepository {
    Eater save(Eater eater);

    List<Eater> findByGrade(Long grade);

    List<EaterRatioResponse> getEaterRation(String mealType, Date mealDate);

    Integer getNotEaterCount(MealType mealType, Date mealDate);

    List<EaterRatioResponse> getEaterRationMonthly(MealType mealType, int year, int month);

    List<EaterRatioResponse> getAllEaterRationMonthly(int year, int month);

    Optional<Eater> findByUserIdAndMealId(@Param("userId") Long userId, @Param("mealId") Integer mealId);

    Double getMonthlyParticipationRate(int year, int month);

    Double getMonthlyTotalCaloriesConsumed(int year, int month);

    void registerEater(Long eaterId);
}
