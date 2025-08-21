package com.example.let.server.domain.auth.controller;

import com.example.let.server.domain.auth.dto.request.LoginRequest;
import com.example.let.server.domain.auth.dto.request.ReissueRequest;
import com.example.let.server.domain.auth.dto.request.SignUpRequest;
import com.example.let.server.domain.auth.service.AuthService;
import com.example.let.server.global.common.BaseResponse;
import com.example.let.server.domain.auth.dto.response.JwtResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    @Operation(
            summary = "회원 가입"
    )
    public ResponseEntity<BaseResponse<Void>> signup(@RequestBody SignUpRequest request) {
        authService.signup(request);

        return BaseResponse.of(null, HttpStatus.CREATED.value());
    }

    @PostMapping("/login")
    @Operation(
            summary = "로그인"
    )
    public ResponseEntity<BaseResponse<JwtResponse>> login(@RequestBody LoginRequest request) {
        return BaseResponse.of(authService.login(request), HttpStatus.OK.value());
    }

    @PostMapping("/reissue")
    @Operation(
            summary = "토큰 재발급"
    )
    public ResponseEntity<BaseResponse<JwtResponse>> reissue(@RequestBody ReissueRequest request) {
        return BaseResponse.of(authService.reissue(request), HttpStatus.OK.value());
    }
}
