package com.example.let_server.domain.menu.mapper;

import com.example.let_server.domain.menu.domain.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface MenuMapper {
    void save(Menu menu);

    Optional<Menu> findByMenuId(Long menuId);

    void updateCurrentRank(@Param("menuId") Long menuId, @Param("rank") int rank);

    Optional<Menu> findByName(String menuName);
}
