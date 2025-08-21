package com.example.let.server.domain.exercises.mapper;

import com.example.let.server.domain.exercises.domain.Exercises;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExerciseMapper {
    List<Exercises> findAll();
}
