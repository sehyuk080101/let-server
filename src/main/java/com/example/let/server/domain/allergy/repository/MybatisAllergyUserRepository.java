package com.example.let.server.domain.allergy.repository;

import com.example.let.server.domain.allergy.domain.AllergyUser;
import com.example.let.server.domain.allergy.mapper.AllergyUserMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MybatisAllergyUserRepository implements AllergyUserRepository {
    private final AllergyUserMapper allergyUserMapper;

    @Override
    public void insertAllergyUser(AllergyUser allergyUser) { allergyUserMapper.insertAllergyUser(allergyUser); }
}
