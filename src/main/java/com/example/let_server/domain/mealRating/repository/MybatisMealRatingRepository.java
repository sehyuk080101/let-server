package com.example.let_server.domain.mealRating.repository;

import com.example.let_server.domain.mealRating.mapper.MealRatingMapper;
import com.example.let_server.domain.menu.domain.Menu;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MybatisMealRatingRepository implements MealRatingRepository {
    private final MealRatingMapper mealRatingMapper;
    @Override
    public void updateMenuScoreByWilson() {
        mealRatingMapper.updateMenuScoreByWilson();
    }
}
