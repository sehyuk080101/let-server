package com.example.let.server.domain.eater.mapper;

import com.example.let.server.domain.eater.domain.Eater;
import com.example.let.server.domain.eater.dto.response.EaterRatioResponse;
import com.example.let.server.domain.meal.domain.MealType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Mapper
public interface EaterMapper {
    void insertEater(Eater eater);
    
    void insertEaterBatch(List<Eater> eaters);

    List<Eater> findByGrade(Long grade);

    List<EaterRatioResponse> getEaterRation(@Param("mealType") String mealType,@Param("mealDate") Date mealDate);

    Integer getNotEaterCount(@Param("mealType") MealType mealType, @Param("mealDate") Date mealDate);

    List<EaterRatioResponse> getEaterRationMonthly(@Param("mealType") MealType mealType,@Param("year") int year,@Param("month") int month);

    List<EaterRatioResponse> getAllEaterRationMonthly(@Param("year") int year, @Param("month") int month);

    Optional<Eater> findByUserIdAndMealId(@Param("userId") Long userId, @Param("mealId") Integer mealId);

    Double getMonthlyParticipationRate(@Param("year") int year, @Param("month") int month);

    Double getMonthlyTotalCaloriesConsumed(@Param("year") int year, @Param("month") int month);

    void registerEater(@Param("eaterId") Long eaterId);
}
