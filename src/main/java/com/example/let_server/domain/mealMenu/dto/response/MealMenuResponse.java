package com.example.let_server.domain.mealMenu.dto.response;

import com.example.let_server.domain.meal.dto.response.MealResponse;
import com.example.let_server.domain.mealMenu.domain.MealMenu;
import com.example.let_server.domain.menu.dto.MenuResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MealMenuResponse {
    private Long mealMenuId;
    private MenuResponse menu;
    private MealResponse meal;


    public static MealMenuResponse of(MealMenu mealMenu) {
        return MealMenuResponse.builder()
                .mealMenuId(mealMenu.getMealMenuId())
                .meal(MealResponse.of(mealMenu.getMeal()))
                .menu(MenuResponse.of(mealMenu.getMenu()))
                .build();
    }
}
