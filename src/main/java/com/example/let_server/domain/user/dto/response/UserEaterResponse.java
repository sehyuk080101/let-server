package com.example.let_server.domain.user.dto.response;

import com.example.let_server.domain.user.domain.User;
import lombok.Builder;

@Builder
public record UserEaterResponse(
        Long userId,
        Long studentId,
        String realName
) {
    public static UserEaterResponse of(User user) {
        return UserEaterResponse.builder()
                .userId(user.getUserId())
                .studentId(user.getStudentId())
                .realName(user.getRealName())
                .build();
    }
}
