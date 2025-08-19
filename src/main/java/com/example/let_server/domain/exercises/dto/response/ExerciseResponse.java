package com.example.let_server.domain.exercises.dto.response;

import com.example.let_server.domain.exercises.domain.ExerciseCategory;
import com.example.let_server.domain.exercises.domain.Exercises;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseResponse {
    private Long id;
    private ExerciseCategory category;
    private Integer duration;
    private String title;
    private String description;
    private String method;

    public static ExerciseResponse of(Exercises exercise) {
        return ExerciseResponse.builder()
                .id(exercise.getId())
                .category(exercise.getCategory())
                .duration(exercise.getDuration())
                .title(exercise.getTitle())
                .description(exercise.getDescription())
                .method(exercise.getMethod())
                .build();
    }
}