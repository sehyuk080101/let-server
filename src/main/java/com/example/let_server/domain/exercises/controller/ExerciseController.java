package com.example.let_server.domain.exercises.controller;

import com.example.let_server.domain.exercises.docs.ExerciseDocs;
import com.example.let_server.domain.exercises.dto.response.ExerciseResponse;
import com.example.let_server.domain.exercises.service.ExerciseService;
import com.example.let_server.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercises")
@RequiredArgsConstructor
public class ExerciseController implements ExerciseDocs {

    private final ExerciseService exerciseService;

    @GetMapping
    @Override
    public ResponseEntity<BaseResponse<List<ExerciseResponse>>> getAllExercises() {
        return BaseResponse.of(exerciseService.getAllExercises());
    }
}