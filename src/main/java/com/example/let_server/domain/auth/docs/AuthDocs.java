package com.example.let_server.domain.auth.docs;

import com.example.let_server.global.common.BaseResponse;
import com.example.let_server.global.security.jwt.dto.Jwt;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;


@Tag(name = "auth", description = "인증 API")
public interface AuthDocs {
    @Operation(
            summary = "회원 가입"
    )
     ResponseEntity<BaseResponse<Void>> signup();

    @Operation(
            summary = "로그인"
    )
    public ResponseEntity<BaseResponse<Jwt>> login();

    @Operation(
            summary = "토큰 재발급"
    )
    public ResponseEntity<BaseResponse<Jwt>> reissue();
}
