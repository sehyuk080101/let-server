package com.example.let.server.domain.meal.repository;

import com.example.let.server.domain.meal.domain.Meal;
import com.example.let.server.domain.meal.domain.MealType;
import com.example.let.server.domain.meal.mapper.MealMapper;
import com.example.let.server.domain.statistics.dto.response.LowParticipationMeal;
import com.example.let.server.domain.statistics.dto.response.MealStatistics;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MybatisMealRepository implements MealRepository {
    private final MealMapper mealMapper;

    @Override
    public Meal save(Meal meal) {
        mealMapper.save(meal);
        return meal;
    }

    @Override
    public Optional<Meal> findById(Integer mealId) {
        return mealMapper.findById(mealId);
    }

    @Override
    public Optional<Meal> findByMealTypeAndMealDate(MealType mealType, Date mealDate) {
        return mealMapper.findByMealTypeAndMealDate(mealType, mealDate);
    }

    @Override
    public List<Meal> findByMealDate(Date mealDate) {
        return mealMapper.findByMealDate(mealDate);
    }

    @Override
    public Long countByYearAndMonth(int year, int month) {
        return mealMapper.countByYearAndMonth(year, month);
    }

    @Override
    public Double sumCaloriesByYearAndMonth(int year, int month) {
        return mealMapper.sumCaloriesByYearAndMonth(year, month);
    }

    @Override
    public MealStatistics getMealStatistics(Long mealId) {
        return mealMapper.getMealStatistics(mealId);
    }

    @Override
    public List<LowParticipationMeal> findLowParticipationMeals(int threshold, String period) {
        return mealMapper.findLowParticipationMeals(threshold, period);
    }
}
