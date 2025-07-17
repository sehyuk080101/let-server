package com.example.let_server.domain.menu.docs;

import com.example.let_server.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "menu", description = "Menu 관련 API")
public interface MenuDocs {
    @Operation(summary = "메뉴 좋아요 기능")
    ResponseEntity<BaseResponse<Void>> increaseLike(@PathVariable("menuId") Long menuId);

    @Operation(summary = "메뉴 싫어요 기능")
    ResponseEntity<BaseResponse<Void>> increaseDislikeCount(@PathVariable("menuId") Long menuId);
}

