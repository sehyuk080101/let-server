package com.example.let_server.global.security.jwt.dto;

public record Jwt(
        String accessToken,
        String refreshToken
) {
}
