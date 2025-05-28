package com.example.let_server.domain.user.repository;

import com.example.let_server.domain.user.domain.User;
import com.example.let_server.domain.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
public class MybatisUserRepository implements UserRepository {

    private final UserMapper userMapper;

    @Override
    public User save(User user) {
        userMapper.save(user);
        return user;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userMapper.existsByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
