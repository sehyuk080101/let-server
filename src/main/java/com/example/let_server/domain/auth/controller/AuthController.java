package com.example.let_server.domain.auth.controller;

import com.example.let_server.domain.auth.dto.request.LoginRequest;
import com.example.let_server.domain.auth.dto.request.ReissueRequest;
import com.example.let_server.domain.auth.dto.request.SignUpRequest;
import com.example.let_server.domain.auth.service.AuthService;
import com.example.let_server.global.common.BaseResponse;
import com.example.let_server.global.security.jwt.dto.Jwt;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@Tag(name = "auth", description = "인증 API")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    @Operation(
            summary = "회원 가입"
    )
    public ResponseEntity<BaseResponse<Void>> signup(@RequestBody SignUpRequest request) {
        authService.signup(request);

        return BaseResponse.of(null, 201);
    }

    @PostMapping("/login")
    @Operation(
            summary = "로그인"
    )
    public ResponseEntity<BaseResponse<Jwt>> login(@RequestBody LoginRequest request) {

        return BaseResponse.of(authService.login(request), 201);
    }

    @PostMapping("/reissue")
    @Operation(
            summary = "토큰 재발급"
    )
    public ResponseEntity<BaseResponse<Jwt>> reissue(@RequestBody ReissueRequest request) {
        return BaseResponse.of(authService.reissue(request), 201);
    }
}
