package com.example.let.server.domain.eater.error;

import com.example.let.server.global.error.CustomError;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EaterError implements CustomError {
    INVALID_GRADE(400, "Invalid grade value. Grade must be 1~3.");

    private final int status;
    private final String message;

    @Override
    public String getCode() {
        return name();
    }
}
