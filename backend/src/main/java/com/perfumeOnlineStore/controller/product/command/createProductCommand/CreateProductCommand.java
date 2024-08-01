package com.perfumeOnlineStore.controller.product.command.createProductCommand;

import an.awesome.pipelinr.Command;
import com.perfumeOnlineStore.entity.Product;
import com.perfumeOnlineStore.mapper.Default;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
public class CreateProductCommand implements Command<CreateProductCommandResponse> {
    @NotBlank(message = "Name must be set")
    private String name;
    @NotBlank(message = "Description must be set")
    private String description;
    @NotBlank(message = "Brand must be set")
    private String brand;
    @NotNull(message = "Price must be set")
    @Min(value = 1, message = "Price must be greater tan zero")
    private Double price;
    @NotBlank(message = "Components must be set")
    private String components;
    @NotBlank(message = "Scent groups must be set")
    private String scentGroups;
    @NotNull(message = "Quantity must be set")
    @Min(value = 0, message = "Quantity can't be less than zero")
    private Integer quantity;
    @NotNull(message = "Gender must be set")
    private Product.Gender gender;
    @NotNull(message = "Volume must be set")
    @Min(value = 1, message = "Volume must be greater tan zero")
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
