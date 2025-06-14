package com.example.let_server.domain.menuRank.repository;

import com.example.let_server.domain.menuRank.dto.response.MenuRankingDto;

import java.util.Date;
import java.util.List;

public interface MenuRankRepository {
    void updateMenuScoreByWilson();
    List<MenuRankingDto> findAllOrderByScoreDesc();
    void saveMenuRankHistory(Long menuId, Date date, int rank, int rankDiff);
    Integer getRankDiff(Long menuId,Date date);
}
