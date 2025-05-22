package com.example.let_server.domain.mealMenu.repository;

import com.example.let_server.domain.mealMenu.domain.MealMenu;
import com.example.let_server.domain.mealMenu.mapper.MealMenuMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MybatisMealMenuRepository implements MealMenuRepository {

    private final MealMenuMapper mealMenuMapper;

    @Override
    public MealMenu save(MealMenu mealMenu) {
        mealMenuMapper.save(mealMenu);
        return mealMenu;
    }
}
