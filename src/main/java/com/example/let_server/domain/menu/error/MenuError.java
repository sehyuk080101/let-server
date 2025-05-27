package com.example.let_server.domain.menu.error;

import com.example.let_server.global.error.CustomError;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum MenuError implements CustomError {
    MENU_NOT_FOUND(404, "Menu not found");

    private final int status;
    private final String message;

    @Override
    public String getCode() {
        return name();
    }
}
