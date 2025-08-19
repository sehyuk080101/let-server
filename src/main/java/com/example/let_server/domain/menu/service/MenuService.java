package com.example.let_server.domain.menu.service;

import com.example.let_server.domain.menu.domain.Menu;
import java.util.List;

public interface MenuService {
    Menu save(String menuName);
    Menu findByMenuId(Long menuId);
    void increaseLikeCount(Long menuId);
    void increaseDislikeCount(Long menuId);
    List<Menu> getAllMenus();
    Menu getMenuById(Long menuId);
}
