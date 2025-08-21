package com.example.let.server.global.security.jwt.dto;

public record Jwt(
        String accessToken,
        String refreshToken
) {
}
