package com.example.let_server.domain.user.controller;

import com.example.let_server.domain.user.docs.UserDocs;
import com.example.let_server.domain.user.dto.response.UserInfoResponse;
import com.example.let_server.domain.user.service.UserService;
import com.example.let_server.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController implements UserDocs {
    private final UserService userService;

    @GetMapping("/me")
    @Override
    public ResponseEntity<BaseResponse<UserInfoResponse>> getMe(){
        return BaseResponse.of(userService.getMe());
    }
}
