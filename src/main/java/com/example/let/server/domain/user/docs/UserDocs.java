package com.example.let.server.domain.user.docs;

import com.example.let.server.domain.user.dto.response.UserInfoResponse;
import com.example.let.server.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "user", description = "유저 관련 API")
public interface UserDocs {
    @Operation(summary = "자신의 정보 불러오기", description = "현재 로그인한 사용자의 정보를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "사용자 정보 조회 성공"),
            @ApiResponse(responseCode = "401", description = "인증되지 않은 사용자"),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    ResponseEntity<BaseResponse<UserInfoResponse>> getMe();

    @Operation(summary = "전체 사용자 수 조회", description = "시스템에 등록된 전체 사용자의 수를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "사용자 수 조회 성공"),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    ResponseEntity<BaseResponse<Long>> getTotalUserCount();

    @Operation(summary = "학년별 사용자 수 조회", description = "학년별로 그룹화된 사용자 수를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "학년별 사용자 수 조회 성공"),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    ResponseEntity<BaseResponse<java.util.Map<Integer, Long>>> getUserCountByGrade();
}
