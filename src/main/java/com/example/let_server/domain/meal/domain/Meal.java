package com.example.let_server.domain.meal.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Meal {
    private int mealId;
    private Date mealDate;
    private MealType mealType;
    private float score;
    private float calorie;
}
