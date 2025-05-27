package com.example.let_server.domain.allergy.service.impl;

import com.example.let_server.domain.allergy.domain.Allergy;
import com.example.let_server.domain.allergy.repository.AllergyRepository;
import com.example.let_server.domain.allergy.service.AllergyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AllergyServiceImpl implements AllergyService {
    private final AllergyRepository allergyRepository;

    @Override
    public Optional<Allergy> findByAllergyId(Long allergyId) {
        return allergyRepository.findByAllergyId(allergyId);
    }
}
