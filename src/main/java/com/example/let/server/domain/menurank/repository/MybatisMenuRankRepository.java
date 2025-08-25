package com.example.let.server.domain.menurank.repository;

import com.example.let.server.domain.menurank.dto.response.MenuRankingResponse;
import com.example.let.server.domain.menurank.mapper.MenuRankMapper;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
public class MybatisMenuRankRepository implements MenuRankRepository {
    private final MenuRankMapper menuRankMapper;
    @Override
    public void updateMenuScoreByWilson() {
        menuRankMapper.updateMenuScoreByWilson();
    }

    @Override
    public List<MenuRankingResponse> findAllOrderByScoreDesc() {
        return menuRankMapper.findAllOrderByScoreDesc();
    }

    @Override
    public List<MenuRankingResponse> findMenuRankingsOrderByScoreDesc(int limit, int offset,boolean reverse) {
        return menuRankMapper.findMenuRankingsOrderByScoreDesc(limit, offset,reverse);
    }


    @Override
    public void saveMenuRankHistory(Long menuId, Date date, int rank, int rankDiff) {
        menuRankMapper.saveMenuRankHistory(menuId, date, rank, rankDiff);
    }

    @Override
    public Integer getRankDiff(Long menuId, Date date) {
        return menuRankMapper.getRankDiff(menuId,date);
    }
}
