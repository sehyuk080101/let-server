package com.example.let_server.domain.eater.mapper;

import com.example.let_server.domain.eater.domain.Eater;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EaterMapper {
    void insertEater(Eater eater);
}
