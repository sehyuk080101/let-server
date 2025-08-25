package com.example.let.server.domain.menurank.docs;

import com.example.let.server.domain.menurank.dto.response.MenuPageResponse;
import com.example.let.server.domain.menurank.dto.response.MenuRankingResponse;
import com.example.let.server.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Tag(name = "menu-rank", description = "메뉴 랭킹 API")
public interface MenuRankDocs {
    @Operation(summary = "메뉴 랭킹 받아오기")
    ResponseEntity<BaseResponse<MenuPageResponse>> getMenuRankingsPage(@RequestParam(defaultValue = "1") int page,@RequestParam boolean reverse);
    @Operation(summary = "메뉴 랭킹 변화 가져오기")
    ResponseEntity<BaseResponse<Integer>> getRankDiff(@PathVariable Long menuId);
}
