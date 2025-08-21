package com.example.let.server.domain.eater.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class UserCalorieResponse {
    private Long userId;
    private LocalDate date;
    private double totalCalorieIntake;
    private List<MealCalorieInfo> meals;

    @Getter
    @Builder
    public static class MealCalorieInfo {
        private String mealType;
        private double calories;
        private boolean eaten;
    }
}
