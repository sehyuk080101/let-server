package com.example.let_server.domain.auth.service.impl;

import com.example.let_server.domain.auth.dto.request.LoginRequest;
import com.example.let_server.domain.auth.dto.request.ReissueRequest;
import com.example.let_server.domain.auth.dto.request.SignUpRequest;
import com.example.let_server.domain.auth.error.AuthError;
import com.example.let_server.domain.auth.repository.RefreshTokenRepository;
import com.example.let_server.domain.auth.service.AuthService;
import com.example.let_server.domain.user.domain.User;
import com.example.let_server.domain.user.domain.UserRole;
import com.example.let_server.domain.user.error.UserError;
import com.example.let_server.domain.user.repository.UserRepository;
import com.example.let_server.global.error.CustomException;
import com.example.let_server.global.security.jwt.dto.Jwt;
import com.example.let_server.global.security.jwt.enums.JwtType;
import com.example.let_server.global.security.jwt.error.JwtError;
import com.example.let_server.global.security.jwt.provider.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    private final RefreshTokenRepository refreshTokenRepository;

    @Override
    @Transactional
    public void signup(SignUpRequest request) {

        existsByUsername(request.username());

        User user = User.builder()
                .username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .role(UserRole.ROLE_USER)
                .realName(request.realName())
                .studentId(request.studentId())
                .build();

        userRepository.save(user);
    }

    private void existsByUsername(String username) {
        if (userRepository.existsByUsername(username)) {
            throw new CustomException(UserError.USERNAME_DUPLICATION);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Jwt login(LoginRequest request) {
        String username = request.username();
        String password = request.password();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new CustomException(UserError.USER_NOT_FOUND));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new CustomException(AuthError.WRONG_PASSWORD);
        }

        return jwtProvider.generateToken(username);
    }

    @Override
    public Jwt reissue(ReissueRequest request) {
        String refreshToken = request.refreshToken();

        if (jwtProvider.getType(refreshToken) != JwtType.REFRESH)
            throw new CustomException(JwtError.INVALID_TOKEN_TYPE);

        String username = jwtProvider.getSubject(refreshToken);

        if (!refreshTokenRepository.existsByUsername(username))
            throw new CustomException(JwtError.INVALID_REFRESH_TOKEN);

        if (!refreshTokenRepository.findByUsername(username).equals(refreshToken))
            throw new CustomException(JwtError.INVALID_REFRESH_TOKEN);

        if (!userRepository.existsByUsername(username)) throw new CustomException(UserError.USER_NOT_FOUND);


        return jwtProvider.generateToken(username);
    }
}
