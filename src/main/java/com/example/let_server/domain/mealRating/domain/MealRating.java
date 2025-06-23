package com.example.let_server.domain.mealRating.domain;

import com.example.let_server.domain.meal.domain.Meal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MealRating {
    private Long mealRatingId;
    private Meal meal;
    private float rating;
}
