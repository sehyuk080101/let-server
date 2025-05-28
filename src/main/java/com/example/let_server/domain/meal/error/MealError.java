package com.example.let_server.domain.meal.error;

import com.example.let_server.global.error.CustomError;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum MealError implements CustomError {
    MEAL_NOT_FOUND(404,"Meal Not Found"),
    MELA_TYPE_NOT_FOUND(404, "Meal Type not found");

    private final int status;
    private final String message;

    @Override
    public String getCode() {
        return name();
    }
}
