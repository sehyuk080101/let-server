package com.example.let.server.domain.mealamount.service.impl;

import com.example.let.server.domain.meal.domain.Meal;
import com.example.let.server.domain.meal.repository.MealRepository;
import com.example.let.server.domain.mealamount.domain.MealAmount;
import com.example.let.server.domain.mealamount.dto.request.MealAmountRequest;
import com.example.let.server.domain.mealamount.error.MealAmountError;
import com.example.let.server.domain.mealamount.repository.MealAmountRepository;
import com.example.let.server.domain.mealamount.service.MealAmountService;
import com.example.let.server.global.error.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MealAmountServiceImpl implements MealAmountService {
    private final MealAmountRepository mealAmountRepository;
    private final MealRepository mealRepository;

    public void saveMealAmount(MealAmountRequest request) {
        Meal meal = mealRepository.findById(request.mealId()).orElseThrow(() -> new CustomException(MealAmountError.MEAL_NOT_FOUND));

        MealAmount mealAmount = MealAmount
                .builder()
                .meal(meal)
                .rating(request.rating())
                .build();

        mealAmountRepository.save(mealAmount);
    }

    @Override
    public List<MealAmount> findAllMealAmounts() {
        return mealAmountRepository.findAll();
    }

    @Override
    public List<MealAmount> findMealAmountsByMealId(Integer mealId) {
        return mealAmountRepository.findByMealId(mealId);
    }
}
