package com.example.let_server.domain.user.service;

import com.example.let_server.domain.user.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAllUser();
}
