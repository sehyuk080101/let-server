package com.example.let.server.domain.menuallergy.repository;

import com.example.let.server.domain.allergy.domain.Allergy;
import com.example.let.server.domain.menuallergy.domain.MenuAllergy;

import java.util.List;

public interface MenuAllergyRepository {
    MenuAllergy save(MenuAllergy menuAllergy);

    List<Allergy> findAllergyByMealId(Integer mealId);

    void saveAllBatch(Long menuId, List<Long> allergyIds);
}
