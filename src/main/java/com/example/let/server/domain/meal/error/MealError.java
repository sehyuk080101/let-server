package com.example.let.server.domain.meal.error;

import com.example.let.server.global.error.CustomError;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum MealError implements CustomError {
    MEAL_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "Meal Not Found"),
    MEAL_TYPE_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "Meal Type not found");

    private final int status;
    private final String message;

    @Override
    public String getCode() {
        return name();
    }
}
