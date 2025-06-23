package com.example.let_server.domain.menuAllergy.controller;

import com.example.let_server.domain.allergy.dto.response.AllergyResponse;
import com.example.let_server.domain.menuAllergy.service.MenuAllergyService;
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
@RequestMapping("/menuAllergy")
@RequiredArgsConstructor
@Tag(name = "menuAllergy", description = "알러지 관련 API")
public class MenuAllergyController {
    private final MenuAllergyService menuAllergyService;

    @GetMapping("/{mealId}")
    @Operation(summary = "급식에 따른 알러지 검색")
    public ResponseEntity<List<AllergyResponse>> getAllergyByMealId(@PathVariable("mealId") Integer mealId) {
        return ResponseEntity.ok(menuAllergyService.getAllergyByMealId(mealId));
    }
}
