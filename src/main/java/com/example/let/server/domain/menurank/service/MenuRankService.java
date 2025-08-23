package com.example.let.server.domain.menurank.service;

import com.example.let.server.domain.menurank.dto.response.MenuPageResponse;
import com.example.let.server.domain.menurank.dto.response.MenuRankingResponse;

import java.util.List;

public interface MenuRankService {
    List<MenuRankingResponse> getMenuRankings();

    MenuPageResponse getMenuRankingsPage(int page);

    Integer getRankDiff(Long menuId);
}
