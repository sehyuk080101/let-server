package com.example.let.server.domain.allergy.repository;

import com.example.let.server.domain.allergy.domain.Allergy;

import java.util.Optional;

public interface AllergyRepository {
    Optional<Allergy> findByAllergyId(Long allergyId);
    Optional<Allergy> findByAllergyName(String allergyName);
    boolean existsByAllergyName(String allergyName);
    void save(Allergy allergy);
}
