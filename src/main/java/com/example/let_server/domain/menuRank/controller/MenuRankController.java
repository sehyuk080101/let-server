package com.example.let_server.domain.menuRank.controller;

import com.example.let_server.domain.menuRank.dto.response.MenuRankingDto;
import com.example.let_server.domain.menuRank.service.MenuRankService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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
    public List<MenuRankingDto> getMenuRankings(){
        return menuRankService.getMenuRankings();
    }
}
