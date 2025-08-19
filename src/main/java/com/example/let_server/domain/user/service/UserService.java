package com.example.let_server.domain.user.service;

import com.example.let_server.domain.user.domain.User;
import com.example.let_server.domain.user.dto.response.UserInfoResponse;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> findAllUser();
    UserInfoResponse getMe();
    Long getTotalUserCount();
    Map<Integer, Long> getUserCountByGrade();
}
