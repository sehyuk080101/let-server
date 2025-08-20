package com.example.let.server.domain.allergy.service;

import com.example.let.server.domain.allergy.domain.Allergy;

public interface AllergyService {
    Allergy findByAllergyId(Long allergyId);
}
