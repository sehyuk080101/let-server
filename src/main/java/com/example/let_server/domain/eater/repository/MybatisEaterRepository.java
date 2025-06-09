package com.example.let_server.domain.eater.repository;

import com.example.let_server.domain.eater.domain.Eater;
import com.example.let_server.domain.eater.dto.response.EaterRatioResponse;
import com.example.let_server.domain.eater.mapper.EaterMapper;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
public class MybatisEaterRepository implements EaterRepository {
    private final EaterMapper eaterMapper;

    @Override
    public Eater save(Eater eater) {
        eaterMapper.insertEater(eater);
        return eater;
    }

    @Override
    public List<Eater> findByGrade(Long grade) {
        return eaterMapper.findByGrade(grade);
    }

    @Override
    public List<EaterRatioResponse> getEaterRation(String mealType, Date mealDate) {
        return eaterMapper.getEaterRation(mealType,mealDate);
    }
}
