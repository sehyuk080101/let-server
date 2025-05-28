package com.example.let_server.domain.meal.mapper;

import com.example.let_server.domain.meal.domain.Meal;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MealMapper {
    void save(Meal meal);
    Optional<Meal> findById(Long mealId);
}
