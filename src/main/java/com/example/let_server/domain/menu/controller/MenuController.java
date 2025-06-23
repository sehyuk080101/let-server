package com.example.let_server.domain.menu.controller;

import com.example.let_server.domain.menu.service.MenuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
@Tag(name = "menu", description = "Menu 관련 API")
public class MenuController {
    private final MenuService menuService;

    @PatchMapping("/like/{menuId}")
    @Operation(summary = "메뉴 좋아요 기능")
    public ResponseEntity<Void> increaseLike(@PathVariable("menuId") Long menuId) {
        menuService.increaseLikeCount(menuId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PatchMapping("/dislike/{menuId}")
    @Operation(summary = "메뉴 싫어요 기능")
    private ResponseEntity<Void> increaseDislikeCount(@PathVariable("menuId") Long menuId) {
        menuService.increaseDislikeCount(menuId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
