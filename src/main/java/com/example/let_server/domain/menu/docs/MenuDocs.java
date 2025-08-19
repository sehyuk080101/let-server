package com.example.let_server.domain.menu.docs;

import com.example.let_server.domain.menu.domain.Menu;
import com.example.let_server.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Tag(name = "menu", description = "메뉴 관련 API")
public interface MenuDocs {
    
    @Operation(summary = "메뉴 좋아요", description = "특정 메뉴의 좋아요 수를 1 증가시킵니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "좋아요 증가 성공"),
            @ApiResponse(responseCode = "404", description = "메뉴를 찾을 수 없음"),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    ResponseEntity<BaseResponse<Void>> increaseLike(
            @Parameter(description = "메뉴 ID", example = "1")
            @PathVariable("menuId") Long menuId
    );

    @Operation(summary = "메뉴 싫어요", description = "특정 메뉴의 싫어요 수를 1 증가시킵니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "싫어요 증가 성공"),
            @ApiResponse(responseCode = "404", description = "메뉴를 찾을 수 없음"),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    ResponseEntity<BaseResponse<Void>> increaseDislikeCount(
            @Parameter(description = "메뉴 ID", example = "1")
            @PathVariable("menuId") Long menuId
    );

    @Operation(summary = "전체 메뉴 조회", description = "시스템에 등록된 모든 메뉴를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "메뉴 목록 조회 성공"),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    ResponseEntity<BaseResponse<List<Menu>>> getAllMenus();

    @Operation(summary = "메뉴 상세 조회", description = "특정 메뉴의 상세 정보를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "메뉴 조회 성공"),
            @ApiResponse(responseCode = "404", description = "메뉴를 찾을 수 없음"),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    ResponseEntity<BaseResponse<Menu>> getMenuById(
            @Parameter(description = "메뉴 ID", example = "1")
            @PathVariable("menuId") Long menuId
    );
}

