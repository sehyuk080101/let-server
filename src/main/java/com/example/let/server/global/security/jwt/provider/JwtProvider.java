package com.example.let.server.global.security.jwt.provider;

import com.example.let.server.domain.auth.repository.RefreshTokenRepository;
import com.example.let.server.domain.user.domain.User;
import com.example.let.server.domain.user.error.UserError;
import com.example.let.server.domain.user.repository.UserRepository;
import com.example.let.server.global.error.CustomException;
import com.example.let.server.global.security.details.CustomUserDetails;
import com.example.let.server.global.security.jwt.config.JwtProperties;
import com.example.let.server.domain.auth.dto.response.JwtResponse;
import com.example.let.server.global.security.jwt.enums.JwtType;
import com.example.let.server.global.security.jwt.error.JwtError;
import io.jsonwebtoken.*;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtProvider {
    private static final String TYPE = "JWT";
    private static final String TOKEN_TYPE = "type";
    private static final String BEARER_PREFIX = "Bearer ";

    private final JwtProperties jwtProperties;
    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private SecretKey key;

    @PostConstruct
    protected void init() {
        key = new SecretKeySpec(
                jwtProperties.getSecretKey().getBytes(StandardCharsets.UTF_8),
                Jwts.SIG.HS512.key().build().getAlgorithm());
    }

    public JwtResponse generateToken(String username) {
        Date now = new Date();

        String accessToken = Jwts.builder()
                .header()
                .type(TYPE)
                .and()
                .subject(username)
                .claims()
                .add(TOKEN_TYPE, JwtType.ACCESS.name())
                .issuedAt(now)
                .expiration(new Date(now.getTime() + jwtProperties.getAccessTokenExpiration()))
                .and()
                .signWith(key)
                .compact();

        String refreshToken = Jwts.builder()
                .header()
                .type(TYPE)
                .and()
                .subject(username)
                .claims()
                .add(TOKEN_TYPE, JwtType.REFRESH.name())
                .issuedAt(now)
                .expiration(new Date((now.getTime() + jwtProperties.getRefreshTokenExpiration())))
                .and()
                .signWith(key)
                .compact();

        refreshTokenRepository.save(username, refreshToken);

        return new JwtResponse(accessToken, refreshToken);
    }

    public Authentication getAuthentication(String token) {
        Claims claims = getClaims(token);

        if (getType(token) != JwtType.ACCESS) {
            throw new CustomException(JwtError.INVALID_TOKEN_TYPE);
        }

        User user = userRepository.findByUsername(claims.getSubject())
                .orElseThrow(() -> new CustomException(UserError.USER_NOT_FOUND));

        UserDetails details = new CustomUserDetails(user);

        return new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());

    }

    public String extractToken(HttpServletRequest request) {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (StringUtils.hasText(token) && token.startsWith(BEARER_PREFIX)) {
            return token.substring(BEARER_PREFIX.length());
        }

        return null;
    }

    public String getSubject(String token) {
        return getClaims(token).getSubject();
    }

    private Claims getClaims(String token) {
        try {
            return Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (ExpiredJwtException e) {
            throw new CustomException(JwtError.EXPIRED_TOKEN);
        } catch (UnsupportedJwtException e) {
            throw new CustomException(JwtError.UNSUPPORTED_TOKEN);
        } catch (MalformedJwtException e) {
            throw new CustomException(JwtError.MALFORMED_TOKEN);
        } catch (IllegalArgumentException e) {
            throw new CustomException(JwtError.INVALID_TOKEN);
        }
    }

    public JwtType getType(String token) {
        return JwtType.valueOf((String) Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload().get(TOKEN_TYPE));
    }
}
