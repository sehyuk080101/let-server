package com.example.let_server.domain.eater.repository;

import com.example.let_server.domain.eater.domain.Eater;
import com.example.let_server.domain.eater.mapper.EaterMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MybatisEaterRepository implements EaterRepository {
    private final EaterMapper eaterMapper;

    @Override
    public Eater save(Eater eater) {
        eaterMapper.insertEater(eater);
        return eater;
    }
}
