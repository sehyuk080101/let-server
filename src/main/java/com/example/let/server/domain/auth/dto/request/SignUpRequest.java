package com.example.let.server.domain.auth.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record SignUpRequest(
        @NotBlank
        @Size(max = 25)
        String username,
        @NotBlank
        @Size(min = 8, max = 32)
        String password,
        @NotBlank
        Long studentId,
        @NotBlank
        String realName
) {
}
