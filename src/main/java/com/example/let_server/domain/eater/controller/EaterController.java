package com.example.let_server.domain.eater.controller;

import com.example.let_server.domain.eater.dto.response.EaterResponse;
import com.example.let_server.domain.eater.service.EaterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/eater")
@Tag(name = "eater",description = "식사자 관련 API")
public class EaterController {
    private final EaterService eaterService;

    @GetMapping("/{grade}")
    @Operation(summary = "학년별 식사자 조회")
    public ResponseEntity<List<EaterResponse>> getByGrade(@PathVariable Long grade) {
        return ResponseEntity.ok(eaterService.findByGrade(grade));
    }
}
