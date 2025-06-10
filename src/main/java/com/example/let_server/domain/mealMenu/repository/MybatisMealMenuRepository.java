package com.example.let_server.domain.mealMenu.repository;

import com.example.let_server.domain.meal.dto.response.MaxEatersMealWithCountResponse;
import com.example.let_server.domain.mealMenu.domain.MealMenu;
import com.example.let_server.domain.mealMenu.mapper.MealMenuMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class MybatisMealMenuRepository implements MealMenuRepository {

    private final MealMenuMapper mealMenuMapper;

    @Override
    public MealMenu save(MealMenu mealMenu) {
        mealMenuMapper.save(mealMenu);
        return mealMenu;
    }

    @Override
    public List<MealMenu> findMonthlyMealMenu(Map<String, Object> params) {
        return mealMenuMapper.findMonthlyMealMenu(params);
    }

    @Override
    public List<MaxEatersMealWithCountResponse> findMaxEatersPerMealType(int year, int month) {
        return mealMenuMapper.findMaxEatersPerMealType(year, month);
    }
}
