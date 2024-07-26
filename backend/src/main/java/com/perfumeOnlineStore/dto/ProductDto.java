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

    @Default
    public ProductDto(String name,
                      String description,
                      String brand,
                      Double price,
                      String components,
                      String scentGroups,
                      Integer quantity,
                      Product.Gender gender,
                      Integer volume
    ) {
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.price = price;
        this.components = components;
        this.scentGroups = scentGroups;
        this.quantity = quantity;
        this.gender = gender;
        this.volume = volume;
    }
}
