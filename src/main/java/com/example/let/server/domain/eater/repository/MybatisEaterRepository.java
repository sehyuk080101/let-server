package com.example.let.server.domain.eater.repository;

import com.example.let.server.domain.eater.domain.Eater;
import com.example.let.server.domain.eater.dto.response.EaterRatioResponse;
import com.example.let.server.domain.eater.mapper.EaterMapper;
import com.example.let.server.domain.meal.domain.MealType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MybatisEaterRepository implements EaterRepository {
    private final EaterMapper eaterMapper;

    @Override
    public Eater save(Eater eater) {
        eaterMapper.insertEater(eater);
        return eater;
    }

    @Override
    public void saveAll(List<Eater> eaters) {
        if (!eaters.isEmpty()) {
            eaterMapper.insertEaterBatch(eaters);
        }
    }

    @Override
    public List<Eater> findByGrade(Long grade) {
        return eaterMapper.findByGrade(grade);
    }

    @Override
    public List<EaterRatioResponse> getEaterRation(String mealType, Date mealDate) {
        return eaterMapper.getEaterRation(mealType,mealDate);
    }

    @Override
    public Integer getNotEaterCount(MealType mealType, Date mealDate) {
        return eaterMapper.getNotEaterCount(mealType,mealDate);
    }

    @Override
    public List<EaterRatioResponse> getEaterRationMonthly(MealType mealType,int year,int month) {
        return eaterMapper.getEaterRationMonthly(mealType,year,month);
    }

    @Override
    public List<EaterRatioResponse> getAllEaterRationMonthly(int year, int month) {
        return eaterMapper.getAllEaterRationMonthly(year, month);
    }

    @Override
    public Optional<Eater> findByUserIdAndMealId(Long userId, Integer mealId) {
        return eaterMapper.findByUserIdAndMealId(userId, mealId);
    }

    @Override
    public Double getMonthlyParticipationRate(int year, int month) {
        return eaterMapper.getMonthlyParticipationRate(year, month);
    }

    @Override
    public Double getMonthlyTotalCaloriesConsumed(int year, int month) {
        return eaterMapper.getMonthlyTotalCaloriesConsumed(year, month);
    }

    @Override
    public void registerEater(Long eaterId) {
        eaterMapper.registerEater(eaterId);
    }
}
