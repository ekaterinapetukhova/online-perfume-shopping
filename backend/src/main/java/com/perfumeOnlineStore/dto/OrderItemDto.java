package com.perfumeOnlineStore.dto;

import lombok.Data;

@Data
public class OrderItemDto {
    private Long id;
    private Integer quantity;
    private Double price;
}
