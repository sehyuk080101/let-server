package com.example.let_server.domain.menuAllergy.mapper;

import com.example.let_server.domain.menuAllergy.domain.MenuAllergy;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuAllergyMapper {
    void save(MenuAllergy menuAllergy);
}
