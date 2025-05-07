package com.example.let_server.global.config.mybatis;

import com.example.let_server.domain.user.mapper.UserMapper;
import com.example.let_server.domain.user.repository.MybatisUserRepository;
import com.example.let_server.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class MybatisConfig {
    private final UserMapper userMapper;

    @Bean
    public UserRepository userRepository() {
        return new MybatisUserRepository(userMapper);
    }
}
