package com.example.let_server.domain.mealRating.mapper;

import com.example.let_server.domain.mealRating.domain.MealRating;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MealRatingMapper {
    void save(MealRating mealRating);

    List<MealRating> findByMealId(@Param("mealId") int mealId);

    Double getMonthlyAverageRating(@Param("year") int year, @Param("month") int month);
}
