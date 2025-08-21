package com.example.let.server.domain.auth.dto.response;

public record JwtResponse(
        String accessToken,
        String refreshToken
) {
}
