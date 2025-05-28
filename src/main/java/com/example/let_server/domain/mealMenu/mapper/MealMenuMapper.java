package com.example.let_server.domain.mealMenu.mapper;

import com.example.let_server.domain.mealMenu.domain.MealMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MealMenuMapper {
    void save(MealMenu mealMenu);

    List<MealMenu> findMonthlyMealMenu(Map<String, Object> params);
}
