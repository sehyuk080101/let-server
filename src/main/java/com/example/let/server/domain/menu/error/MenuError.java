package com.example.let.server.domain.menu.error;

import com.example.let.server.global.error.CustomError;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum MenuError implements CustomError {
    MENU_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "Menu not found");

    private final int status;
    private final String message;

    @Override
    public String getCode() {
        return name();
    }
}
