package com.example.let_server.domain.menuAllergy.repository;

import com.example.let_server.domain.allergy.domain.Allergy;
import com.example.let_server.domain.menuAllergy.domain.MenuAllergy;

import java.util.List;
import java.util.Optional;

public interface MenuAllergyRepository {
    MenuAllergy save(MenuAllergy menuAllergy);
    List<Allergy> findAllergyByMealId(Long mealId);
    void saveAllBatch(Long menuId, List<Long> allergyIds);
}
