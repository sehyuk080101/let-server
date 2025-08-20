package com.example.let.server.domain.meal.service;

import com.example.let.server.domain.meal.domain.Meal;
import com.example.let.server.domain.meal.domain.MealType;
import com.example.let.server.domain.meal.error.MealError;
import com.example.let.server.domain.meal.repository.MealRepository;
import com.example.let.server.domain.statistics.dto.response.LowParticipationMeal;
import com.example.let.server.domain.statistics.dto.response.MealStatistics;
import com.example.let.server.domain.statistics.dto.response.MealDetails;
import com.example.let.server.global.error.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MealService {
    private final MealRepository mealRepository;

    public Meal createMeal(Date mealDate, String mealType, float calorie) {
        Meal meal = Meal.builder()
                .mealDate(mealDate)
                .mealType(MealType.valueOf(mealType))
                .calorie(calorie)
                .build();
        return mealRepository.save(meal);
    }

    public Meal getMealById(Integer mealId) {
        return mealRepository.findById(mealId)
                .orElseThrow(()->new CustomException(MealError.MEAL_NOT_FOUND));
    }

    public Meal getMealByMealTypeAndMealDate(MealType mealType, Date mealDate) {
        return mealRepository.findByMealTypeAndMealDate(mealType,mealDate)
                .orElseThrow(()->new CustomException(MealError.MEAL_NOT_FOUND));
    }

    public List<Meal> getMealsByDate(Date mealDate) {
        return mealRepository.findByMealDate(mealDate);
    }

    public Long getMonthlyMealCount(int year, int month) {
        return mealRepository.countByYearAndMonth(year, month);
    }

    public Double getMonthlyTotalCalories(int year, int month) {
        return mealRepository.sumCaloriesByYearAndMonth(year, month);
    }

    public MealStatistics getMealStatistics(Long mealId) {
        return mealRepository.getMealStatistics(mealId);
    }

    public List<LowParticipationMeal> findLowParticipationMeals(int threshold, String period) {
        return mealRepository.findLowParticipationMeals(threshold, period);
    }

    public MealDetails getMealDetails(Long mealId) {
        Meal meal = mealRepository.findById(mealId.intValue())
                .orElseThrow(() -> new CustomException(MealError.MEAL_NOT_FOUND));
        
        return MealDetails.builder()
                .mealId(Long.valueOf(meal.getMealId()))
                .menuName("메뉴 정보를 가져오는 중...")
                .mealDate(meal.getMealDate().toString())
                .mealType(meal.getMealType().name())
                .calorie((int) meal.getCalorie())
                .description("급식 상세 정보")
                .price(0.0)
                .build();
    }
}
