package com.example.let.server.global.security.holder;

import com.example.let.server.domain.user.domain.User;
import com.example.let.server.domain.user.error.UserError;
import com.example.let.server.domain.user.repository.UserRepository;
import com.example.let.server.global.error.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SecurityHolder {
    private final UserRepository userRepository;

    public User getUser() {
        return userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).orElseThrow(() -> new CustomException(UserError.USER_NOT_FOUND));
    }
}
