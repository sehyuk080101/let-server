package com.example.let.server.global.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public record BaseResponse<T>(
        T data,
        int status,
        String message
) {
    private static final int DEFAULT_SUCCESS_STATUS = HttpStatus.OK.value();
    private static final String DEFAULT_MESSAGE = "";

    public static <T> ResponseEntity<BaseResponse<T>> of(T data) {
        return BaseResponse.of(data, DEFAULT_SUCCESS_STATUS, DEFAULT_MESSAGE);
    }

    public static <T> ResponseEntity<BaseResponse<T>> of(T data, int status) {
        return BaseResponse.of(data, status, DEFAULT_MESSAGE);
    }

    public static <T> ResponseEntity<BaseResponse<T>> of(T data, int status, String message) {
        return ResponseEntity.status(status).body(new BaseResponse<>(data, status, message));
    }
}
