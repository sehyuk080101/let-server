package com.example.let_server.domain.menu.repository;

import com.example.let_server.domain.menu.domain.Menu;
import com.example.let_server.domain.menu.mapper.MenuMapper;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class MybatisMenuRepository implements MenuRepository {
    private final MenuMapper menuMapper;

    @Override
    public Menu save(Menu menu) {
        menuMapper.save(menu);
        return menu;
    }

    @Override
    public Optional<Menu> findByMenuId(Long menuId) {
        return menuMapper.findByMenuId(menuId);
    }

    @Override
    public void updateCurrentRank(Long menuId, int rank) {
        menuMapper.updateCurrentRank(menuId,rank);
    }

    @Override
    public Optional<Menu> findByName(String menuName) {
        return menuMapper.findByName(menuName);
    }
}
