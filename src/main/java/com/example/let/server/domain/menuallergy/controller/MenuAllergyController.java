package com.example.let.server.domain.menuallergy.controller;

import com.example.let.server.domain.allergy.dto.response.AllergyResponse;
import com.example.let.server.domain.menuallergy.docs.MenuAllergyDocs;
import com.example.let.server.domain.menuallergy.service.MenuAllergyService;
import com.example.let.server.global.common.BaseResponse;
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
public class MenuAllergyController implements MenuAllergyDocs {
    private final MenuAllergyService menuAllergyService;

    @GetMapping("/{mealId}")
    @Override
    public ResponseEntity<BaseResponse<List<AllergyResponse>>> getAllergyByMealId(@PathVariable("mealId") Integer mealId) {
        return BaseResponse.of(menuAllergyService.getAllergyByMealId(mealId));
    }
}
