package com.example.let_server.domain.menuAllergy.mapper;

import com.example.let_server.domain.allergy.domain.Allergy;
import com.example.let_server.domain.menuAllergy.domain.MenuAllergy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MenuAllergyMapper {
    void save(MenuAllergy menuAllergy);
    List<Allergy> findAllergyByMealId(Long mealId);
}
