package com.example.let_server.domain.menu.mapper;

import com.example.let_server.domain.menu.domain.Menu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuMapper {
    void save(Menu menu);
}
