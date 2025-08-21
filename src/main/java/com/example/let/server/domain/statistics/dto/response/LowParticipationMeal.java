package com.example.let.server.domain.statistics.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
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
