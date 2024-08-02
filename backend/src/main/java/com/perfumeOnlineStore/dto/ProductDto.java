package com.perfumeOnlineStore.dto;

import com.perfumeOnlineStore.entity.Category;
import com.perfumeOnlineStore.entity.Product;
import com.perfumeOnlineStore.mapper.Default;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private String brand;
    private Double price;
    private String components;
    private String scentGroups;
    private Integer quantity;
    private Product.Gender gender;
    private Integer volume;
}
