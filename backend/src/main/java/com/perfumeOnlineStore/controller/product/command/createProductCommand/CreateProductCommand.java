package com.perfumeOnlineStore.controller.product.command.createProductCommand;

import com.perfumeOnlineStore.entity.Product;
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
}
