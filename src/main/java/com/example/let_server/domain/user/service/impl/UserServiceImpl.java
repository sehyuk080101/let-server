package com.example.let_server.domain.user.service.impl;

import com.example.let_server.domain.user.domain.User;
import com.example.let_server.domain.user.repository.UserRepository;
import com.example.let_server.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }
}
