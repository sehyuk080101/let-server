package com.example.let.server.domain.mealamount.dto.request;

import com.example.let.server.domain.mealamount.domain.Rating;
import jakarta.validation.constraints.NotBlank;

public record MealAmountRequest(
    @NotBlank
    Long mealId,
    @NotBlank
    Rating rating
) {
}
