package com.example.let_server.domain.menuAllergy.repository;

import com.example.let_server.domain.menuAllergy.domain.MenuAllergy;
import com.example.let_server.domain.menuAllergy.mapper.MenuAllergyMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MybatisMenuAllergyRepository implements MenuAllergyRepository {
    private final MenuAllergyMapper menuAllergyMapper;

    @Override
    public MenuAllergy save(MenuAllergy menuAllergy) {
        menuAllergyMapper.save(menuAllergy);
        return menuAllergy;
    }
}
