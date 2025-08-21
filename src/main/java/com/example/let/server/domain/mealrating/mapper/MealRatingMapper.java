package com.example.let.server.domain.mealrating.mapper;

import com.example.let.server.domain.mealrating.domain.MealRating;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MealRatingMapper {
    void save(MealRating mealRating);

    List<MealRating> findByMealId(@Param("mealId") int mealId);

    Double getMonthlyAverageRating(@Param("year") int year, @Param("month") int month);
}
