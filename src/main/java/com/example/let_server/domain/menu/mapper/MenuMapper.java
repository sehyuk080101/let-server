package com.example.let_server.domain.menu.mapper;

import com.example.let_server.domain.menu.domain.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MenuMapper {
    void save(Menu menu);

    Optional<Menu> findByMenuId(Long menuId);
}
