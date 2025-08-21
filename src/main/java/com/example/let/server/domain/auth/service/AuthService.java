package com.example.let.server.domain.auth.service;

import com.example.let.server.domain.auth.dto.request.LoginRequest;
import com.example.let.server.domain.auth.dto.request.ReissueRequest;
import com.example.let.server.domain.auth.dto.request.SignUpRequest;
import com.example.let.server.domain.auth.dto.response.JwtResponse;

public interface AuthService {
    void signup(SignUpRequest request);

    JwtResponse login(LoginRequest request);

    JwtResponse reissue(ReissueRequest request);
}
