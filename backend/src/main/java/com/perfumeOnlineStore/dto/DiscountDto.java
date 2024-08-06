package com.perfumeOnlineStore.dto;

import com.perfumeOnlineStore.entity.Product;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class DiscountDto {
    private UUID id;
    private Double percent;
    private String name;
    private LocalDateTime startedDate;
    private LocalDateTime endedDate;
    private String description;
    private List<Product> products;
}
