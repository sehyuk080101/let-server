package com.example.let_server.domain.menu.repository;

import com.example.let_server.domain.menu.domain.Menu;

import java.util.List;
import java.util.Optional;

public interface MenuRepository {
    Menu save(Menu menu);

    Optional<Menu> findByMenuId(Long menuId);

    void updateCurrentRank(Long menuId, int rank);

    Optional<Menu> findByName(String menuName);

    void increaseLikeCount(Long menuId);

    void increaseDislikeCount(Long menuId);

    List<Menu> findAll();
}
