package com.example.let.server.domain.auth.dto.request;

public record LoginRequest(
        String username,
        String password
) {
}
