package com.example.let.server.domain.exercises.service.impl;

import com.example.let.server.domain.exercises.domain.Exercises;
import com.example.let.server.domain.exercises.dto.response.ExerciseResponse;
import com.example.let.server.domain.exercises.repository.ExerciseRepository;
import com.example.let.server.domain.exercises.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;

    @Override
    public List<ExerciseResponse> getAllExercises() {
        log.info("데이터베이스에서 운동 목록 조회");
        List<Exercises> exercises = exerciseRepository.findAll();
        log.info("조회된 운동 개수: {}", exercises.size());
        
        return exercises.stream().map(ExerciseResponse::of).toList();
    }
}