package com.example.let_server.domain.auth.service;

import com.example.let_server.domain.auth.dto.request.LoginRequest;
import com.example.let_server.domain.auth.dto.request.ReissueRequest;
import com.example.let_server.domain.auth.dto.request.SignUpRequest;
import com.example.let_server.global.security.jwt.dto.Jwt;

public interface AuthService {
    void signup(SignUpRequest request);

    Jwt login(LoginRequest request);

    Jwt reissue(ReissueRequest request);
}
