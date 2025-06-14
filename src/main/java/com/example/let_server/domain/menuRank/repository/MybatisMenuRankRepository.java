package com.example.let_server.domain.menuRank.repository;

import com.example.let_server.domain.menuRank.dto.response.MenuRankingDto;
import com.example.let_server.domain.menuRank.mapper.MenuRankMapper;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
public class MybatisMenuRankRepository implements MenuRankRepository {
    private final MenuRankMapper mealRatingMapper;
    @Override
    public void updateMenuScoreByWilson() {
        mealRatingMapper.updateMenuScoreByWilson();
    }

    @Override
    public List<MenuRankingDto> findAllOrderByScoreDesc() {
        return mealRatingMapper.findAllOrderByScoreDesc();
    }

    @Override
    public void saveMenuRankHistory(Long menuId, Date date, int rank, int rankDiff) {
        mealRatingMapper.saveMenuRankHistory(menuId, date, rank, rankDiff);
    }

    @Override
    public Integer getRankDiff(Long menuId, Date date) {
        return mealRatingMapper.getRankDiff(menuId,date);
    }
}
