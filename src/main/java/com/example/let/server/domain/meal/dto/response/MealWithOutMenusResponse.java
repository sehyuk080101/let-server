package com.example.let.server.domain.meal.dto.response;

import com.example.let.server.domain.meal.domain.Meal;
import com.example.let.server.domain.meal.domain.MealType;
import lombok.*;

import java.util.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MealWithOutMenusResponse {
    private int mealId;
    private Date mealDate;
    private MealType mealType;
    private float calorie;

    public static MealWithOutMenusResponse of(Meal meal) {
        return MealWithOutMenusResponse.builder()
                .mealId(meal.getMealId())
                .mealDate(meal.getMealDate())
                .mealType(meal.getMealType())
                .calorie(meal.getCalorie())
                .build();
    }
}
