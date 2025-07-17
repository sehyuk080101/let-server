package com.example.let_server.domain.user.service.impl;

import com.example.let_server.domain.user.domain.User;
import com.example.let_server.domain.user.dto.response.UserInfoResponse;
import com.example.let_server.domain.user.repository.UserRepository;
import com.example.let_server.domain.user.service.UserService;
import com.example.let_server.global.security.holder.SecurityHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final SecurityHolder securityHolder;

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public UserInfoResponse getMe() {
        User currentUser = securityHolder.getUser();
        return UserInfoResponse.of(currentUser);
    }
}
