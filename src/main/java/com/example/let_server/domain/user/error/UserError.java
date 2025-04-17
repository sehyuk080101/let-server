package com.example.let_server.domain.user.error;

import com.example.let_server.global.error.CustomError;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserError implements CustomError {
    USER_NOT_FOUND(404, "User not found"),
    USERNAME_DUPLICATION(409, "Username is already in use");

    private final int status;
    private final String message;

    @Override
    public String getCode() {
        return name();
    }
}
