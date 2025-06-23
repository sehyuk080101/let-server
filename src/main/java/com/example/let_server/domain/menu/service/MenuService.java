package com.example.let_server.domain.menu.service;

import com.example.let_server.domain.menu.domain.Menu;

public interface MenuService {
    Menu save(String menuName);
    Menu findByMenuId(Long menuId);
    void increaseLikeCount(Long menuId);
    void increaseDislikeCount(Long menuId);
}
