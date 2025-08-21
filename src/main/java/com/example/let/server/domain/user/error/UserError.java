package com.example.let.server.domain.user.error;

import com.example.let.server.global.error.CustomError;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UserError implements CustomError {
    USER_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "User not found"),
    USERNAME_DUPLICATION(HttpStatus.CONFLICT.value(), "Username is already in use");

    private final int status;
    private final String message;

    @Override
    public String getCode() {
        return name();
    }
}
