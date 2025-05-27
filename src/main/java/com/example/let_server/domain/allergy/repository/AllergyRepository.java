package com.example.let_server.domain.allergy.repository;

import com.example.let_server.domain.allergy.domain.Allergy;

import java.util.Optional;

public interface AllergyRepository {
    Optional<Allergy> findByAllergyId(Long allergyId);
}
