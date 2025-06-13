package com.example.let_server.domain.menuRank.repository;

import com.example.let_server.domain.menuRank.dto.response.MenuRankingDto;

import java.util.List;

public interface MenuRankRepository {
    void updateMenuScoreByWilson();
    List<MenuRankingDto> findAllOrderByScoreDesc();
}
