package com.example.let.server.domain.user.mapper;

import com.example.let.server.domain.user.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Mapper
public interface UserMapper {
    void save(User user);

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    List<User> findAll();

    Long count();

    List<Map<String, Object>> countByGrade();
}
