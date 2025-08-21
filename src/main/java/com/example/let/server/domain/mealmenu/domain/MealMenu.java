package com.example.let.server.domain.mealmenu.domain;

import com.example.let.server.domain.meal.domain.Meal;
import com.example.let.server.domain.menu.domain.Menu;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MealMenu {
    private Long mealMenuId;
    private Menu menu;
    private Meal meal;
}
