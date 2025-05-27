package com.example.let_server.global.security.details;

import com.example.let_server.domain.user.domain.User;
import com.example.let_server.domain.user.error.UserError;
import com.example.let_server.domain.user.repository.UserRepository;
import com.example.let_server.global.error.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new CustomException(UserError.USER_NOT_FOUND));
        return new CustomUserDetails(user);
    }
}
