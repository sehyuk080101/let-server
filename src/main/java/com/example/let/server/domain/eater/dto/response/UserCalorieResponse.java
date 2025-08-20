package com.example.let.server.domain.eater.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class UserCalorieResponse {
    private Long userId;
    private LocalDate date;
    private double totalCalorieIntake;
    private List<MealCalorieInfo> meals;

    @Data
    @Builder
    public static class MealCalorieInfo {
        private String mealType;
        private double calories;
        private boolean eaten;
    }
}