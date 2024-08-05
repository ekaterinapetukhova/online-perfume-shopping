package com.perfumeOnlineStore.dto;

import com.perfumeOnlineStore.entity.Product;
import lombok.Data;

@Data
public class OrderItemDto {
    private Long id;
    private Product product;
    private Integer quantity;
    private Double price;
}
