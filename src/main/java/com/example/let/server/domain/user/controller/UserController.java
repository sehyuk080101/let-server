package com.example.let.server.domain.user.controller;

import com.example.let.server.domain.user.docs.UserDocs;
import com.example.let.server.domain.user.dto.response.UserInfoResponse;
import com.example.let.server.domain.user.service.UserService;
import com.example.let.server.global.common.BaseResponse;
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

    @GetMapping("/count")
    @Override
    public ResponseEntity<BaseResponse<Long>> getTotalUserCount() {
        Long totalCount = userService.getTotalUserCount();
        return BaseResponse.of(totalCount);
    }

    @GetMapping("/count/by-grade")
    @Override
    public ResponseEntity<BaseResponse<java.util.Map<Integer, Long>>> getUserCountByGrade() {
        java.util.Map<Integer, Long> countByGrade = userService.getUserCountByGrade();
        return BaseResponse.of(countByGrade);
    }
}
