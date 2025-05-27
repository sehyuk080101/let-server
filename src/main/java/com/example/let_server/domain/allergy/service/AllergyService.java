package com.example.let_server.domain.allergy.service;

import com.example.let_server.domain.allergy.domain.Allergy;

import java.util.Optional;

public interface AllergyService {
    Optional<Allergy> findByAllergyId(Long allergyId);
}
