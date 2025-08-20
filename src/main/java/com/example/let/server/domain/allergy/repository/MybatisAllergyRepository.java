package com.example.let.server.domain.allergy.repository;

import com.example.let.server.domain.allergy.domain.Allergy;
import com.example.let.server.domain.allergy.mapper.AllergyMapper;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class MybatisAllergyRepository implements AllergyRepository {
    private final AllergyMapper allergyMapper;

    @Override
    public Optional<Allergy> findByAllergyId(Long allergyId) {
        return allergyMapper.findByAllergyId(allergyId);
    }
}
