package com.example.let_server.domain.allergy.mapper;

import com.example.let_server.domain.allergy.domain.AllergyUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AllergyUserMapper {
    void insertAllergyUser(AllergyUser allergyUser);
}
