package com.perfumeOnlineStore.dto;

import com.perfumeOnlineStore.entity.*;
import lombok.*;

import java.util.*;

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
    private Set<Discount> discounts;
    private Set<OrderItem> orderItems;
}
