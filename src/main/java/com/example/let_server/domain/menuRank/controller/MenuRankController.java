package com.example.let_server.domain.menuRank.controller;

import com.example.let_server.domain.menuRank.docs.MenuRankDocs;
import com.example.let_server.domain.menuRank.dto.response.MenuRankingDto;
import com.example.let_server.domain.menuRank.service.MenuRankService;
import com.example.let_server.global.common.BaseResponse;
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
public class MenuRankController implements MenuRankDocs {
    private final MenuRankService menuRankService;

    @GetMapping
    @Override
    public ResponseEntity<BaseResponse<List<MenuRankingDto>>> getMenuRankings(){
        return BaseResponse.of(menuRankService.getMenuRankings());
    }

    @GetMapping("/diff/{menuId}")
    @Override
    public ResponseEntity<BaseResponse<Integer>> getRankDiff(@PathVariable Long menuId){
        return BaseResponse.of(menuRankService.getRankDiff(menuId));
    }
}
