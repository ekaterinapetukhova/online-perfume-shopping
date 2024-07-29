package com.perfumeOnlineStore.controller.product.command.createProductCommand;

import com.perfumeOnlineStore.entity.Product;
import com.perfumeOnlineStore.mapper.Default;
import lombok.Data;

@Data
public class CreateProductCommand {
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
    public CreateProductCommand(
            String name,
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
