package com.example.let.server.domain.mealrating.repository;

import com.example.let.server.domain.mealrating.domain.MealRating;
import com.example.let.server.domain.mealrating.mapper.MealRatingMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MybatisMealRatingRepository implements MealRatingRepository {
    private final MealRatingMapper mealRatingMapper;
    @Override
    public MealRating save(MealRating mealRating) {
        mealRatingMapper.save(mealRating);
        return mealRating;
    }

    @Override
    public List<MealRating> findByMeal_MealId(int mealId) {
        return mealRatingMapper.findByMealId(mealId);
    }

    @Override
    public Double getMonthlyAverageRating(int year, int month) {
        return mealRatingMapper.getMonthlyAverageRating(year, month);
    }
}
