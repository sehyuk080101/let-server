package com.example.let.server.domain.eater.dto.response;

import com.example.let.server.domain.eater.domain.Eater;
import com.example.let.server.domain.user.dto.response.UserEaterResponse;
import lombok.Builder;


@Builder
public record EaterResponse(
        Long eaterId,
        UserEaterResponse user,
        boolean eaten) {
    public static EaterResponse of(Eater eater) {
        return EaterResponse.builder()
                .eaterId(eater.getEaterId())
                .user(UserEaterResponse.of(eater.getUser()))
                .eaten(eater.isEaten())
                .build();
    }
}
