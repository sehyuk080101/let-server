package com.example.let.server.domain.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User {
    private Long userId;
    private String username;
    private String password;
    private Long studentId;
    private String realName;
    private UserRole role;
}