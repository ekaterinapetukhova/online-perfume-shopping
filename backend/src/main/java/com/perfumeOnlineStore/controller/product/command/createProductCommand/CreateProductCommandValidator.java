package com.perfumeOnlineStore.controller.product.command.createProductCommand;

import com.perfumeOnlineStore.customValidators.commandValidator.CommandValidator;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Set;

@RequiredArgsConstructor
@Slf4j
@Component
public class CreateProductCommandValidator implements CommandValidator<CreateProductCommand, CreateProductCommandResponse> {
    @Override
    public void validate(CreateProductCommand command) {
        if (command.getName() == null || command.getName().trim().isEmpty()) throw new IllegalArgumentException("Name must be set");
        if (command.getBrand() == null || command.getBrand().trim().isEmpty()) throw new IllegalArgumentException("Brand must be set");
        if (command.getDescription() == null || command.getDescription().trim().isEmpty()) throw new IllegalArgumentException("Description must be set");
        if (command.getComponents() == null || command.getComponents().trim().isEmpty()) throw new IllegalArgumentException("Components must be set");
        if (command.getPrice() == null || command.getPrice() <= 0) throw new IllegalArgumentException("Price must be set and be greater than zero");
        if (command.getGender() == null) throw new IllegalArgumentException("Gender must be set");
        if (command.getVolume() == null || command.getVolume() <= 0) throw new IllegalArgumentException("Volume must be set and be greater than zero");
        if (command.getScentGroups() == null || command.getScentGroups().trim().isEmpty()) throw new IllegalArgumentException("Scent groups must be set");
        if (command.getQuantity() == null || command.getQuantity() < 0) throw new IllegalArgumentException("Quantity must be set and has positive number");
    }
}
