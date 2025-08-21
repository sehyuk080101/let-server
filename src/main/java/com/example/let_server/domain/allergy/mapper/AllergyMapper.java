package com.example.let_server.domain.allergy.mapper;

import com.example.let_server.domain.allergy.domain.Allergy;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface AllergyMapper {
    Optional<Allergy> findByAllergyId(Long allergyId);
    Optional<Allergy> findByAllergyName(String allergyName);
    boolean existsByAllergyName(String allergyName);
    void save(Allergy allergy);
}
