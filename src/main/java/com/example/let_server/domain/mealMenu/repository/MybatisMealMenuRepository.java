package com.example.let_server.domain.mealMenu.repository;

import com.example.let_server.domain.mealMenu.domain.MealMenu;
import com.example.let_server.domain.mealMenu.mapper.MealMenuMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MybatisMealMenuRepository implements MealMenuRepository {

    private final MealMenuMapper mealMenuMapper;

    @Override
    public MealMenu save(MealMenu mealMenu) {
        mealMenuMapper.save(mealMenu);
        return mealMenu;
    }

    @Override
    public List<MealMenu> findMonthlyMealMenu(String yearMonth) {
        return mealMenuMapper.findMonthlyMealMenu(yearMonth);
    }
}
