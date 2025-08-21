package com.example.let.server.domain.allergy.error;

import com.example.let.server.global.error.CustomError;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AllergyError implements CustomError {
    ALLERGY_NOT_FOUND(404, "Allergy not found");

    private final int status;
    private final String message;

    @Override
    public String getCode() {
        return name();
    }
}
