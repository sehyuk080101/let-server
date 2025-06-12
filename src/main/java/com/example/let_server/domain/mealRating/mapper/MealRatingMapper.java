package com.example.let_server.domain.mealRating.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MealRatingMapper {
    void updateMenuScoreByWilson();
}
