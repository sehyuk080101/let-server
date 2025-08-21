package com.example.let.server.domain.eater.service;

import com.example.let.server.domain.eater.dto.response.EaterRatioResponse;
import com.example.let.server.domain.eater.dto.response.EaterResponse;
import com.example.let.server.domain.eater.dto.response.UserCalorieResponse;

import java.time.LocalDate;
import java.util.List;

public interface EaterService {
    List<EaterResponse> findByGrade(Long grade);

    List<EaterRatioResponse> getEaterRation(String mealType);

    Integer getNotEaterCount();

    List<EaterRatioResponse> getEaterRationMonthly();

    List<EaterRatioResponse> getAllEaterRationMonthly();

    UserCalorieResponse getUserCalorieIntake(Long userId, LocalDate date);

    Double getMonthlyParticipationRate(int year, int month);

    Double getMonthlyTotalCaloriesConsumed(int year, int month);
}
