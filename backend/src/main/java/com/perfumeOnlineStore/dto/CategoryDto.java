package com.perfumeOnlineStore.dto;

import com.perfumeOnlineStore.entity.Product;
import lombok.Data;

import java.util.Set;

@Data
public class CategoryDto {
    private Long id;
    private String name;
    private String description;
    private Set<Product> products;
}
