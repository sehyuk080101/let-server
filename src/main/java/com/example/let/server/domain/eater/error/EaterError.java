package com.example.let.server.domain.eater.error;

import com.example.let.server.global.error.CustomError;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum EaterError implements CustomError {
    INVALID_GRADE(HttpStatus.BAD_REQUEST.value(), "Invalid grade value. Grade must be 1~3."),
    EATER_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "Eater not found.");

    private final int status;
    private final String message;

    @Override
    public String getCode() {
        return name();
    }
}
