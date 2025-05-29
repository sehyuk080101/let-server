package com.example.let_server.domain.eater.mapper;

import com.example.let_server.domain.eater.domain.Eater;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EaterMapper {
    void insertEater(Eater eater);
    List<Eater> findByGrade(Long grade);
}
