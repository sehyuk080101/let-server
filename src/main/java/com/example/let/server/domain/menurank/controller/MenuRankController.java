package com.example.let.server.domain.menurank.controller;

import com.example.let.server.domain.menurank.docs.MenuRankDocs;
import com.example.let.server.domain.menurank.dto.response.MenuRankingDto;
import com.example.let.server.domain.menurank.service.MenuRankService;
import com.example.let.server.global.common.BaseResponse;
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
