package com.example.let_server.domain.menuAllergy.service.impl;

import com.example.let_server.domain.allergy.domain.Allergy;
import com.example.let_server.domain.allergy.error.AllergyError;
import com.example.let_server.domain.allergy.service.AllergyService;
import com.example.let_server.domain.menu.domain.Menu;
import com.example.let_server.domain.menu.service.MenuService;
import com.example.let_server.domain.menuAllergy.domain.MenuAllergy;
import com.example.let_server.domain.menuAllergy.repository.MenuAllergyRepository;
import com.example.let_server.domain.menuAllergy.service.MenuAllergyService;
import com.example.let_server.global.error.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuAllergyServiceImpl implements MenuAllergyService {
    private final MenuAllergyRepository menuAllergyRepository;
    private final AllergyService allergyService;
    private final MenuService menuService;

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
}
