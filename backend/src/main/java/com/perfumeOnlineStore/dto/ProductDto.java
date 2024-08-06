package com.perfumeOnlineStore.dto;

import com.perfumeOnlineStore.entity.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
public class ProductDto {
    private UUID id;
    private String name;
    private String description;
    private String brand;
    private Double price;
    private String components;
    private String scentGroups;
    private Integer quantity;
    private Product.Gender gender;
    private Integer volume;
    private Category category;
    private List<Discount> discounts;
    private List<OrderItem> orderItems;
}
