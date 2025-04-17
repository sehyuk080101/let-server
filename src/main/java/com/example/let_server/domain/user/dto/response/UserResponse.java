package com.example.let_server.domain.user.dto.response;

import com.example.let_server.domain.user.domain.User;
import com.example.let_server.domain.user.domain.UserRole;
import lombok.Builder;

@Builder
public record UserResponse(
        Long idx,
        String username,
        Long studentId,
        String realName,
        Long schoolId,
        UserRole role
) {
    public static UserResponse of (User user) {
        return UserResponse.builder()
                .idx(user.getId())
                .username(user.getUsername())
                .studentId(user.getStudentId())
                .realName(user.getRealName())
                .schoolId(user.getSchoolId())
                .role(user.getRole())
                .build();
    }
}
