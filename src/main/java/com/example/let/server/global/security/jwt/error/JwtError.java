package com.example.let.server.global.security.jwt.error;

import com.example.let.server.global.error.CustomError;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum JwtError implements CustomError {
    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED.value(), "Expired JWT token"),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED.value(), "Invalid JWT token"),
    UNSUPPORTED_TOKEN(HttpStatus.UNAUTHORIZED.value(), "Unsupported JWT token"),
    MALFORMED_TOKEN(HttpStatus.UNAUTHORIZED.value(), "Malformed JWT token"),
    INVALID_TOKEN_TYPE(HttpStatus.UNAUTHORIZED.value(), "Invalid token type"),
    INVALID_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED.value(), "Invalid refresh token");

    private final int status;
    private final String message;

    @Override
    public String getCode() {
        return name();
    }
}
