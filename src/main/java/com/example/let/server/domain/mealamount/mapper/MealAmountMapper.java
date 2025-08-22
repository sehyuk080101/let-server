package com.example.let.server.domain.mealamount.mapper;

import com.example.let.server.domain.mealamount.domain.MealAmount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MealAmountMapper {
    void save(MealAmount mealAmount);
    List<MealAmount> findAll();
    List<MealAmount> findByMealId(@Param("mealId") Integer mealId);
}
