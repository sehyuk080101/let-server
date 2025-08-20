package com.example.let.server.domain.exercises.service;

import com.example.let.server.domain.exercises.dto.response.ExerciseResponse;

import java.util.List;

public interface ExerciseService {
    List<ExerciseResponse> getAllExercises();
}