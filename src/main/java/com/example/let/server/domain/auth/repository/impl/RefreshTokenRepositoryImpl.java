package com.example.let.server.domain.auth.repository.impl;

import com.example.let.server.domain.auth.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RefreshTokenRepositoryImpl implements RefreshTokenRepository {
    private static final String KEY_PREFIX = "refresh_token:";

    private final RedisTemplate<String, String> redisTemplate;

    @Override
    public void save(String username, String refreshToken) {
        redisTemplate.opsForValue().set(KEY_PREFIX + username, refreshToken);
    }

    @Override
    public String findByUsername(String username) {
        return redisTemplate.opsForValue().get(KEY_PREFIX + username);
    }

    @Override
    public void deleteByUsername(String username) {
        redisTemplate.delete(username);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return redisTemplate.hasKey(KEY_PREFIX + username);
    }
}
