package com.example.let_server.domain.statistics.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LowParticipationMeal {
    private Long mealId;
    private String date;
    private String mealType;
    private String menuName;
    private Double participationRate;
    private Integer eatenCount;
    private Integer totalStudents;
}