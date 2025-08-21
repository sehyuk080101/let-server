package com.example.let.server.domain.mealamount.mapper;

import com.example.let.server.domain.mealamount.domain.MealAmount;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MealAmountMapper {
    void save(MealAmount mealAmount);
}
