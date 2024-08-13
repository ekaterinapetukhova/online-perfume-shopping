package com.perfumeOnlineStore.service;

import com.perfumeOnlineStore.entity.*;
import com.perfumeOnlineStore.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;
    private final UserService userService;

    @Value("${security.jwt.refresh-expiration-ms}")
    private Long refreshExpirationMs;

    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    public RefreshToken createRefreshToken() {
        RefreshToken refreshToken = RefreshToken.builder()
                .expiryDate(Instant.now().plusMillis(refreshExpirationMs))
                .token(UUID.randomUUID().toString())
                .build();

        return refreshTokenRepository.save(refreshToken);
    }

    public RefreshToken verifyExpiration(RefreshToken refreshToken) {
        if (refreshToken.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenRepository.delete(refreshToken);
            throw new RuntimeException("Refresh token " + refreshToken.getToken() + " was expired. Please make a new signin request");
        }

        return refreshToken;
    }
}
