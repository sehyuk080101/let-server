package com.example.let.server.domain.menuallergy.service;


import com.example.let.server.domain.allergy.dto.response.AllergyResponse;

import java.util.List;

public interface MenuAllergyService {
    void save(Long menuId, Long allergyId);
    List<AllergyResponse> getAllergyByMealId(Integer mealId);
    void saveAllBatch(Long menuId, List<Long> allergyIds);
}
