package com.example.let_server.domain.menuRank.mapper;

import com.example.let_server.domain.menuRank.dto.response.MenuRankingDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuRankMapper {
    void updateMenuScoreByWilson();
    List<MenuRankingDto> findAllOrderByScoreDesc();
}
