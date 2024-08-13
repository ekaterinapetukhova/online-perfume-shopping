package com.perfumeOnlineStore.dto;

import lombok.Data;

@Data
public class RefreshTokenResponseDto {
    private String accessToken;
    private String refreshToken;
    private final String tokenType = "Bearer ";
}
