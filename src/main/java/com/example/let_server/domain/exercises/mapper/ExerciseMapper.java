package com.example.let_server.domain.exercises.mapper;

import com.example.let_server.domain.exercises.domain.Exercises;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExerciseMapper {
    List<Exercises> findAll();
}