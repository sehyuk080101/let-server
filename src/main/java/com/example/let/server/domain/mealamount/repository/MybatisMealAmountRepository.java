package com.example.let.server.domain.mealamount.repository;

import com.example.let.server.domain.mealamount.domain.MealAmount;
import com.example.let.server.domain.mealamount.mapper.MealAmountMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MybatisMealAmountRepository implements MealAmountRepository {
    private final MealAmountMapper mealAmountMapper;

    @Override
    public void save(MealAmount mealAmount) { mealAmountMapper.save(mealAmount); }

    @Override
    public List<MealAmount> findAll() { return mealAmountMapper.findAll(); }

    @Override
    public List<MealAmount> findByMealId(Integer mealId) { return mealAmountMapper.findByMealId(mealId); }

}
