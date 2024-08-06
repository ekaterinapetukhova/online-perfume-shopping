package com.perfumeOnlineStore.dto;

import com.perfumeOnlineStore.entity.*;
import lombok.Data;

import java.util.UUID;

@Data
public class OrderItemDto {
    private UUID id;
    private Product product;
    private Integer quantity;
    private Double price;
    private Order order;
}
