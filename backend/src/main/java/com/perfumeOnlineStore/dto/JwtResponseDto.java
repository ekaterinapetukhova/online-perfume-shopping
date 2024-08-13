package com.perfumeOnlineStore.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtResponseDto {
    private String refreshToken;
    private String accessToken;
}
