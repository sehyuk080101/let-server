package com.example.let_server.global.security.jwt.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "jwt")
public class JwtPropoties {
    private String secretKey;
    private long accessTokenExpiration;
    private long refreshTokenExpiration;
}
