package com.example.let.server.domain.exercises.controller;

import com.example.let.server.domain.exercises.docs.ExerciseDocs;
import com.example.let.server.domain.exercises.dto.response.ExerciseResponse;
import com.example.let.server.domain.exercises.service.ExerciseService;
import com.example.let.server.global.common.BaseResponse;
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
