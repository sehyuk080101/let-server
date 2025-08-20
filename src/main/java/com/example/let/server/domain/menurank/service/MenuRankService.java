package com.example.let.server.domain.menurank.service;

import com.example.let.server.domain.menurank.dto.response.MenuRankingDto;

import java.util.List;

public interface MenuRankService {
    List<MenuRankingDto> getMenuRankings();
    Integer getRankDiff(Long menuId);
}
