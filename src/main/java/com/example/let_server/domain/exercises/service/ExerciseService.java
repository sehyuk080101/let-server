package com.example.let_server.domain.exercises.service;

import com.example.let_server.domain.exercises.dto.response.ExerciseResponse;

import java.util.List;

public interface ExerciseService {
    List<ExerciseResponse> getAllExercises();
}