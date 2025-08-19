package com.example.let_server.domain.menu.controller;

import com.example.let_server.domain.menu.docs.MenuDocs;
import com.example.let_server.domain.menu.domain.Menu;
import com.example.let_server.domain.menu.service.MenuService;
import com.example.let_server.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    @Override
    public ResponseEntity<BaseResponse<List<Menu>>> getAllMenus() {
        List<Menu> menus = menuService.getAllMenus();
        return BaseResponse.of(menus);
    }

    @GetMapping("/{menuId}")
    @Override
    public ResponseEntity<BaseResponse<Menu>> getMenuById(@PathVariable("menuId") Long menuId) {
        Menu menu = menuService.getMenuById(menuId);
        return BaseResponse.of(menu);
    }
}
