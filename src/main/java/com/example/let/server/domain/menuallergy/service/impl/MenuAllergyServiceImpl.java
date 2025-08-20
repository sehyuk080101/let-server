package com.example.let.server.domain.menuallergy.service.impl;

import com.example.let.server.domain.allergy.domain.Allergy;
import com.example.let.server.domain.allergy.dto.response.AllergyResponse;
import com.example.let.server.domain.allergy.service.AllergyService;
import com.example.let.server.domain.meal.service.MealService;
import com.example.let.server.domain.menu.domain.Menu;
import com.example.let.server.domain.menu.service.MenuService;
import com.example.let.server.domain.menuallergy.domain.MenuAllergy;
import com.example.let.server.domain.menuallergy.repository.MenuAllergyRepository;
import com.example.let.server.domain.menuallergy.service.MenuAllergyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuAllergyServiceImpl implements MenuAllergyService {
    private final MenuAllergyRepository menuAllergyRepository;
    private final AllergyService allergyService;
    private final MenuService menuService;
    private final MealService mealService;

    @Override
    public void save(Long menuId, Long allergyId) {
        Allergy allergy = allergyService.findByAllergyId(allergyId);

        Menu menu = menuService.findByMenuId(menuId);

        MenuAllergy menuAllergy = MenuAllergy.builder()
                .allergy(allergy)
                .menu(menu)
                .build();
        menuAllergyRepository.save(menuAllergy);
    }

    @Override
    public List<AllergyResponse> getAllergyByMealId(Integer mealId) {
        mealService.getMealById(mealId);
        List<Allergy> allergies = menuAllergyRepository.findAllergyByMealId(mealId);
        return allergies.stream().map(AllergyResponse::of).toList();
    }

    @Override
    @Transactional
    public void saveAllBatch(Long menuId, List<Long> allergyIds) {
        if (allergyIds == null || allergyIds.isEmpty()) return;
        menuAllergyRepository.saveAllBatch(menuId, allergyIds);
    }
}
