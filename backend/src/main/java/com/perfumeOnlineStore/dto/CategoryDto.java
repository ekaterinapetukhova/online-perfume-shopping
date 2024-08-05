package com.perfumeOnlineStore.dto;

import com.perfumeOnlineStore.entity.Product;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDto {
    private Long id;
    private String name;
    private String description;
    private List<Product> products;
}
