package com.example.let_server.domain.eater.service;

import com.example.let_server.domain.eater.dto.response.EaterRatioResponse;
import com.example.let_server.domain.eater.dto.response.EaterResponse;

import java.util.Date;
import java.util.List;

public interface EaterService {
    List<EaterResponse> findByGrade(Long grade);
    List<EaterRatioResponse> getEaterRation(String mealType);
}
