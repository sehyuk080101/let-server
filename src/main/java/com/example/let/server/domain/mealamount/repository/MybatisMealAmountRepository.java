package com.example.let.server.domain.mealamount.repository;

import com.example.let.server.domain.mealamount.domain.MealAmount;
import com.example.let.server.domain.mealamount.mapper.MealAmountMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MybatisMealAmountRepository implements MealAmountRepository {
    private final MealAmountMapper mealAmountMapper;

    @Override
    public void save(MealAmount mealAmount) { mealAmountMapper.save(mealAmount); }
}
