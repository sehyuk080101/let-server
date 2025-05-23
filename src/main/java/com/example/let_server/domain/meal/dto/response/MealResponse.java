package com.example.let_server.domain.meal.dto.response;

import com.example.let_server.domain.meal.domain.Meal;
import com.example.let_server.domain.meal.domain.MealType;
import com.example.let_server.domain.menu.domain.Menu;
import com.example.let_server.domain.menu.dto.MenuResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MealResponse {
    private int mealId;
    private Date mealDate;
    private MealType mealType;
    private float calorie;
    private List<MenuResponse> menus;

    public static MealResponse of(Meal meal) {
        return MealResponse.builder()
                .mealId(meal.getMealId())
                .mealDate(meal.getMealDate())
                .mealType(meal.getMealType())
                .calorie(meal.getCalorie())
                .menus(new ArrayList<>())
                .build();
    }
}
