package com.example.let.server.domain.menurank.repository;

import com.example.let.server.domain.menurank.dto.response.MenuRankingResponse;

import java.util.Date;
import java.util.List;

public interface MenuRankRepository {
    void updateMenuScoreByWilson();
    List<MenuRankingResponse> findAllOrderByScoreDesc();
    void saveMenuRankHistory(Long menuId, Date date, int rank, int rankDiff);
    Integer getRankDiff(Long menuId,Date date);
}
