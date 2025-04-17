package com.example.let_server.global.security.holder;

import com.example.let_server.domain.user.domain.User;
import com.example.let_server.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SecurityHolder {
    private final UserRepository userRepository;

    public User getUser() {
        return userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
}
