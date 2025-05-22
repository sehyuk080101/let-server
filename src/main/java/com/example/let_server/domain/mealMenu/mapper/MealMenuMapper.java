package com.example.let_server.domain.mealMenu.mapper;

import com.example.let_server.domain.mealMenu.domain.MealMenu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MealMenuMapper{
    void save(MealMenu mealMenu);
}
