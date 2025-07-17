package com.example.let_server.domain.menuRank.docs;

import com.example.let_server.domain.menuRank.dto.response.MenuRankingDto;
import com.example.let_server.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Tag(name = "menu-rank", description = "메뉴 랭킹 API")
public interface MenuRankDocs {
    @Operation(summary = "메뉴 랭킹 받아오기")
    ResponseEntity<BaseResponse<List<MenuRankingDto>>> getMenuRankings();

    @Operation(summary = "메뉴 랭킹 변화 가져오기")
    ResponseEntity<BaseResponse<Integer>> getRankDiff(@PathVariable Long menuId);
}