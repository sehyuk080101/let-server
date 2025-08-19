package com.example.let_server.domain.exercises.repository;

import com.example.let_server.domain.exercises.domain.Exercises;
import com.example.let_server.domain.exercises.mapper.ExerciseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MybatisExerciseRepository implements ExerciseRepository {

    private final ExerciseMapper exerciseMapper;

    @Override
    public List<Exercises> findAll() {
        return exerciseMapper.findAll();
    }
}