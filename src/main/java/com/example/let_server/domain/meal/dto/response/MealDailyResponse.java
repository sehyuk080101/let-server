package com.example.let_server.domain.meal.dto.response;

import com.example.let_server.domain.meal.domain.MealType;
import com.example.let_server.domain.menu.dto.MenuResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MealDailyResponse {
    private int mealId;
    private Date mealDate;
    private MealType mealType;
    private float calorie;
    private List<MenuResponse> menus;
}
