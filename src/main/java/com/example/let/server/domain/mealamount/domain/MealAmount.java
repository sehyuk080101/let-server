package com.example.let.server.domain.mealamount.domain;

import com.example.let.server.domain.meal.domain.Meal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MealAmount {
    private Long mealAmountId;
    private Meal meal;
    private Rating rating;
}
