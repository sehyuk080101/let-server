package com.example.let.server.domain.menuallergy.repository;

import com.example.let.server.domain.allergy.domain.Allergy;
import com.example.let.server.domain.menuallergy.domain.MenuAllergy;
import com.example.let.server.domain.menuallergy.mapper.MenuAllergyMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MybatisMenuAllergyRepository implements MenuAllergyRepository {
    private final MenuAllergyMapper menuAllergyMapper;

    @Override
    public MenuAllergy save(MenuAllergy menuAllergy) {
        menuAllergyMapper.save(menuAllergy);
        return menuAllergy;
    }

    @Override
    public List<Allergy> findAllergyByMealId(Integer mealId) {
        return menuAllergyMapper.findAllergyByMealId(mealId);
    }

    @Override
    public void saveAllBatch(Long menuId, List<Long> allergyIds) {
        menuAllergyMapper.saveAllBatch(menuId, allergyIds);
    }
}
