package com.example.let.server.domain.statistics.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MealDetails {
    private Long mealId;
    private String menuName;
    private String mealDate;
    private String mealType;
    private Integer calorie;
    private String description;
    private Double price;
}