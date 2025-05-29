package com.example.let_server.domain.eater.repository;

import com.example.let_server.domain.eater.domain.Eater;

import java.util.List;

public interface EaterRepository {
    Eater save(Eater eater);
    List<Eater> findByGrade(Long grade);
}
