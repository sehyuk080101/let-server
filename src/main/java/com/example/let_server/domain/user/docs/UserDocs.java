package com.example.let_server.domain.user.docs;

import com.example.let_server.domain.user.dto.response.UserInfoResponse;
import com.example.let_server.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "user", description = "유저 관련 API")
public interface UserDocs {
    @Operation(summary = "자신의 정보 불러오기")
    ResponseEntity<BaseResponse<UserInfoResponse>> getMe();
}