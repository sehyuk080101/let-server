package com.example.let_server.domain.exercises.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Exercises {
    private Long id;
    private ExerciseCategory category;
    private Integer duration;
    private String title;
    private String description;
    private String method;
}
