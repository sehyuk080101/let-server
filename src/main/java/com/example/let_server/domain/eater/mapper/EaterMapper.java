package com.example.let_server.domain.eater.mapper;

import com.example.let_server.domain.eater.domain.Eater;
import com.example.let_server.domain.eater.dto.response.EaterRatioResponse;
import com.example.let_server.domain.meal.domain.MealType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface EaterMapper {
    void insertEater(Eater eater);
    List<Eater> findByGrade(Long grade);
    List<EaterRatioResponse> getEaterRation(@Param("mealType") String mealType,@Param("mealDate") Date mealDate);
    Integer getNotEaterCount(@Param("mealType") MealType mealType, @Param("mealDate") Date mealDate);
}
