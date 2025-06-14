package com.example.let_server.domain.menuRank.controller;

import com.example.let_server.domain.menuRank.dto.response.MenuRankingDto;
import com.example.let_server.domain.menuRank.service.MenuRankService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu-rank")
@RequiredArgsConstructor
@Tag(name = "menu-rank", description = "메뉴 랭킹 API")
public class MenuRankController {
    private final MenuRankService menuRankService;

    @GetMapping
    @Operation(summary = "메뉴 랭킹 받아오기")
    public ResponseEntity<List<MenuRankingDto>> getMenuRankings(){
        return ResponseEntity.ok(menuRankService.getMenuRankings());
    }

    @GetMapping("/diff/{menuId}")
    @Operation(summary = "메뉴 랭킹 변화 가져오기")
    public ResponseEntity<Integer> getRankDiff(@PathVariable Long menuId){
        return ResponseEntity.ok(menuRankService.getRankDiff(menuId));
    }
}
