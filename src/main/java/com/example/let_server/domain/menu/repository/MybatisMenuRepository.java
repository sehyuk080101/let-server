package com.example.let_server.domain.menu.repository;

import com.example.let_server.domain.menu.domain.Menu;
import com.example.let_server.domain.menu.mapper.MenuMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MybatisMenuRepository implements MenuRepository {
    private final MenuMapper menuMapper;


    @Override
    public Menu save(Menu menu) {
        menuMapper.save(menu);
        return menu;
    }
}
