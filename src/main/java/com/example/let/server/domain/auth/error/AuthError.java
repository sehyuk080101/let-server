package com.example.let.server.domain.auth.error;

import com.example.let.server.global.error.CustomError;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum AuthError implements CustomError {
    WRONG_PASSWORD(HttpStatus.BAD_REQUEST.value(), "Wrong password");

    private final int status;
    private final String message;

    @Override
    public String getCode() {
        return name();
    }
}
