package com.example.let_server.domain.menuAllergy.service.impl;

import com.example.let_server.domain.allergy.domain.Allergy;
import com.example.let_server.domain.allergy.dto.response.AllergyResponse;
import com.example.let_server.domain.allergy.error.AllergyError;
import com.example.let_server.domain.allergy.service.AllergyService;
import com.example.let_server.domain.meal.service.MealService;
import com.example.let_server.domain.menu.domain.Menu;
import com.example.let_server.domain.menu.service.MenuService;
import com.example.let_server.domain.menuAllergy.domain.MenuAllergy;
import com.example.let_server.domain.menuAllergy.repository.MenuAllergyRepository;
import com.example.let_server.domain.menuAllergy.service.MenuAllergyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<AllergyResponse> getAllergyByMealId(Long mealId) {
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
