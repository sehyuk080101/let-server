package com.example.let.server.domain.exercises.docs;

import com.example.let.server.domain.exercises.dto.response.ExerciseResponse;
import com.example.let.server.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "exercises", description = "운동 관련 API")
public interface ExerciseDocs {
    @Operation(summary = "운동 목록 조회")
    ResponseEntity<BaseResponse<List<ExerciseResponse>>> getAllExercises();
}
