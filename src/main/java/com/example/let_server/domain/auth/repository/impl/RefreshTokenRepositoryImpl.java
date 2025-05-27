package com.example.let_server.domain.auth.repository.impl;

import com.example.let_server.domain.auth.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RefreshTokenRepositoryImpl implements RefreshTokenRepository {
    private final RedisTemplate<String, String> redisTemplate;


    @Override
    public void save(String username, String refreshToken) {
        redisTemplate.opsForValue().set("refresh_token:" + username, refreshToken);
    }

    @Override
    public String findByUsername(String username) {
        return redisTemplate.opsForValue().get("refresh_token:" + username);
    }

    @Override
    public void deleteByUsername(String username) {
        redisTemplate.delete(username);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return redisTemplate.hasKey("refresh_token:" + username);
    }
}
