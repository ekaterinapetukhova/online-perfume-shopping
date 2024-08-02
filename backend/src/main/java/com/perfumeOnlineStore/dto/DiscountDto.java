package com.perfumeOnlineStore.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DiscountDto {
    private Long id;
    private Double percent;
    private String name;
    private LocalDateTime startedDate;
    private LocalDateTime endedDate;
    private String description;
}
