package com.example.let.server.domain.user.dto.response;

import com.example.let.server.domain.user.domain.User;
import com.example.let.server.domain.user.domain.UserRole;
import lombok.Builder;

@Builder
public record UserResponse(
        Long userId,
        String username,
        Long studentId,
        String realName,
        UserRole role
) {
    public static UserResponse of(User user) {
        return UserResponse.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .studentId(user.getStudentId())
                .realName(user.getRealName())
                .role(user.getRole())
                .build();
    }
}
