package com.example.let_server.domain.menu.controller;

import com.example.let_server.domain.menu.docs.MenuDocs;
import com.example.let_server.domain.menu.service.MenuService;
import com.example.let_server.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController implements MenuDocs {
    private final MenuService menuService;

    @PatchMapping("/like/{menuId}")
    @Override
    public ResponseEntity<BaseResponse<Void>> increaseLike(@PathVariable("menuId") Long menuId) {
        menuService.increaseLikeCount(menuId);
        return BaseResponse.of(null, 204);
    }


    @PatchMapping("/dislike/{menuId}")
    @Override
    public ResponseEntity<BaseResponse<Void>> increaseDislikeCount(@PathVariable("menuId") Long menuId) {
        menuService.increaseDislikeCount(menuId);
        return BaseResponse.of(null, 204);
    }
}
