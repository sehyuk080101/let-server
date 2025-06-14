package com.example.let_server.domain.menuRank.service;

import com.example.let_server.domain.menuRank.dto.response.MenuRankingDto;

import java.util.List;

public interface MenuRankService {
    List<MenuRankingDto> getMenuRankings();
    Integer getRankDiff(Long menuId);
}
