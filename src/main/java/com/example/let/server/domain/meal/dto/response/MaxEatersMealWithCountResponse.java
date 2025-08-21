package com.example.let.server.domain.meal.dto.response;

import com.example.let.server.domain.meal.domain.MealType;
import com.example.let.server.domain.menu.dto.response.MenuResponse;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MaxEatersMealWithCountResponse {
    private int mealId;
    private Date mealDate;
    private MealType mealType;
    private float calorie;
    private List<MenuResponse> menus;
    private int eaterCount;
}
