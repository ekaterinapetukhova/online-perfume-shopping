package com.perfumeOnlineStore.controller.product.command.updateProductCommand;

import org.springframework.stereotype.Component;

@Component
public class UpdateProductCommandValidator {

    public void validate(UpdateProductCommand command) {
        if (command.getId() == null) throw new IllegalArgumentException("Product's ID isn't specified");
        if (command.getName() == null || command.getName().isEmpty()) throw new IllegalArgumentException("Name must not be empty");
        if (command.getDescription() == null || command.getDescription().isEmpty()) throw new IllegalArgumentException("Description must not be empty");
        if (command.getBrand() == null || command.getBrand().isEmpty()) throw new IllegalArgumentException("Brand must not be empty");
        if (command.getPrice() == null || command.getPrice() <= Double.parseDouble("0")) throw new IllegalArgumentException("Price must not be empty or be equal or less than zero");
        if (command.getComponents() == null || command.getComponents().isEmpty()) throw new IllegalArgumentException("Components must not be empty");
        if (command.getScentGroups() == null || command.getScentGroups().isEmpty()) throw new IllegalArgumentException("ScentGroups must not be empty");
        if (command.getGender() == null) throw new IllegalArgumentException("Gender must not be empty");
        if (command.getQuantity() == null || command.getQuantity() < 0) throw new IllegalArgumentException("Quantity must not be empty or be equal or less than zero");
        if (command.getVolume() == null || command.getVolume() <= 0) throw new IllegalArgumentException("Volume must not be empty or be equal or less than zero");
    }
}
