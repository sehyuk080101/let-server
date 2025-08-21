package com.example.let.server.domain.statistics.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MealStatistics {
    private Long mealId;
    private String date;
    private String mealType;
    private String menuName;
    private Integer totalStudents;
    private Integer eatenCount;
    private Double participationRate;
    private Double averageRating;
    private Integer calorie;
}