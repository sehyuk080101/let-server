package com.example.let.server.domain.mealrating.domain;

import com.example.let.server.domain.meal.domain.Meal;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MealRating {
    private Long mealRatingId;
    private Meal meal;
    private float rating;
}
