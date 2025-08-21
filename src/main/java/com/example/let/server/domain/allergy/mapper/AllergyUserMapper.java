package com.example.let.server.domain.allergy.mapper;

import com.example.let.server.domain.allergy.domain.AllergyUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AllergyUserMapper {
    void insertAllergyUser(AllergyUser allergyUser);
}
