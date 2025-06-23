package com.example.let_server.domain.mealRating.dto.response;


import com.example.let_server.domain.meal.dto.response.MealWithOutMenusResponse;
import com.example.let_server.domain.mealRating.domain.MealRating;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MealRatingResponse {
    private MealWithOutMenusResponse meal;
    private float rating;

    public static MealRatingResponse of(MealRating mealRating) {
        return MealRatingResponse.builder()
                .meal(MealWithOutMenusResponse.of(mealRating.getMeal()))
                .rating(mealRating.getRating())
                .build();
    }
}
