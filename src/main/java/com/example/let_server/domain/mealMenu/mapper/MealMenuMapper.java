package com.example.let_server.domain.mealMenu.mapper;

import com.example.let_server.domain.mealMenu.domain.MealMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MealMenuMapper{
    void save(MealMenu mealMenu);
    List<MealMenu> findMonthlyMealMenu(@Param("yearMonth") String yearMonth);
}
