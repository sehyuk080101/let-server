package com.example.let.server.domain.allergy.service.impl;

import com.example.let.server.domain.allergy.domain.Allergy;
import com.example.let.server.domain.allergy.error.AllergyError;
import com.example.let.server.domain.allergy.repository.AllergyRepository;
import com.example.let.server.domain.allergy.service.AllergyService;
import com.example.let.server.global.error.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AllergyServiceImpl implements AllergyService {
    private final AllergyRepository allergyRepository;

    @Override
    public Allergy findByAllergyId(Long allergyId) {
        return allergyRepository.findByAllergyId(allergyId)
                .orElseThrow(()->new CustomException(AllergyError.ALLERGY_NOT_FOUND));
    }
}
