package com.example.let.server.domain.mealrating.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MealRatingRequest {
    private int mealId;
    private float rating;
}
