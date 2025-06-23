package com.example.let_server.domain.mealRating.mapper;

import com.example.let_server.domain.mealRating.domain.MealRating;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MealRatingMapper {
    void save(MealRating mealRating);
}
