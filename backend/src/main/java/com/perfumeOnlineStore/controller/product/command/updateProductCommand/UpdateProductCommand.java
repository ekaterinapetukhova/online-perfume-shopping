package com.perfumeOnlineStore.controller.product.command.updateProductCommand;

import com.perfumeOnlineStore.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateProductCommand {
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
