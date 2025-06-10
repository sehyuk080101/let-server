package com.example.let_server.domain.eater.repository;

import com.example.let_server.domain.eater.domain.Eater;
import com.example.let_server.domain.eater.dto.response.EaterRatioResponse;
import com.example.let_server.domain.meal.domain.MealType;

import java.util.Date;
import java.util.List;

public interface EaterRepository {
    Eater save(Eater eater);
    List<Eater> findByGrade(Long grade);
    List<EaterRatioResponse> getEaterRation(String mealType, Date mealDate);
    Integer getNotEaterCount(MealType mealType, Date mealDate);
}
