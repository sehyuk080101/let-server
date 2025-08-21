package com.example.let.server.domain.mealmenu.error;

import com.example.let.server.global.error.CustomError;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum MealMenuError implements CustomError {
    MEAL_DATA_PARSING_FAILED(HttpStatus.INTERNAL_SERVER_ERROR.value(), "급식 데이터 파싱에 실패했습니다");

    private final int status;
    private final String message;

    @Override
    public String getCode() {
        return name();
    }
}
