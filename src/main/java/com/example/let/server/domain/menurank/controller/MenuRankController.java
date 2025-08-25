package com.example.let.server.domain.menurank.controller;

import com.example.let.server.domain.menurank.docs.MenuRankDocs;
import com.example.let.server.domain.menurank.dto.response.MenuPageResponse;
import com.example.let.server.domain.menurank.dto.response.MenuRankingResponse;
import com.example.let.server.domain.menurank.service.MenuRankService;
import com.example.let.server.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu-rank")
@RequiredArgsConstructor
public class MenuRankController implements MenuRankDocs {
    private final MenuRankService menuRankService;

    @GetMapping
    @Override
    public ResponseEntity<BaseResponse<MenuPageResponse>> getMenuRankingsPage(@RequestParam(defaultValue = "1") int page, @RequestParam boolean reverse){
        return BaseResponse.of(menuRankService.getMenuRankingsPage(page, reverse));
    }

    @GetMapping("/diff/{menuId}")
    @Override
    public ResponseEntity<BaseResponse<Integer>> getRankDiff(@PathVariable Long menuId){
        return BaseResponse.of(menuRankService.getRankDiff(menuId));
    }
}
