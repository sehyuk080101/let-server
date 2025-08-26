package com.example.let.server.domain.user.dto.response;

import com.example.let.server.domain.user.domain.User;
import lombok.Builder;

@Builder
public record UserInfoResponse(
        Long userId,
        String username,
        Long studentId,
        String realName,
        Boolean isAttend
) {
    public static UserInfoResponse of(User user) {
        return UserInfoResponse.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .studentId(user.getStudentId())
                .realName(user.getRealName())
                .build();
    }

    public static UserInfoResponse of(User user, Boolean isAttend) {
        return UserInfoResponse.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .studentId(user.getStudentId())
                .realName(user.getRealName())
                .isAttend(isAttend)
                .build();
    }

}
