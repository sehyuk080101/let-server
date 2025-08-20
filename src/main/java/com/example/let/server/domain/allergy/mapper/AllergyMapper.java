package com.example.let.server.domain.allergy.mapper;

import com.example.let.server.domain.allergy.domain.Allergy;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface AllergyMapper {
    Optional<Allergy> findByAllergyId(Long allergyId);
}
