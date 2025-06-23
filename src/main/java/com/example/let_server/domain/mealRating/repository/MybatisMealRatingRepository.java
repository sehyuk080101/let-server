package com.example.let_server.domain.mealRating.repository;

import com.example.let_server.domain.mealRating.domain.MealRating;
import com.example.let_server.domain.mealRating.mapper.MealRatingMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MybatisMealRatingRepository implements MealRatingRepository {
    private final MealRatingMapper mealRatingMapper;
    @Override
    public MealRating save(MealRating mealRating) {
        mealRatingMapper.save(mealRating);
        return mealRating;
    }
}
