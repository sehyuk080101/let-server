package com.example.let_server.domain.exercises.repository;

import com.example.let_server.domain.exercises.domain.Exercises;

import java.util.List;

public interface ExerciseRepository {
    List<Exercises> findAll();
}