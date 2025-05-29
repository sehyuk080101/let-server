package com.example.let_server.domain.eater.service;

import com.example.let_server.domain.eater.domain.Eater;
import com.example.let_server.domain.eater.dto.response.EaterResponse;

import java.util.List;

public interface EaterService {
    List<EaterResponse> findByGrade(Long grade);
}
