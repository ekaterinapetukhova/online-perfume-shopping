package com.perfumeOnlineStore.controller.product.command.createProductCommand;

import com.perfumeOnlineStore.customValidators.commandValidator.CommandValidator;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@RequiredArgsConstructor
@Component
public class CreateProductCommandValidator implements CommandValidator<CreateProductCommand, CreateProductCommandResponse> {
    private final Validator validator;

    @Override
    public void validate(CreateProductCommand command) {
        Set<ConstraintViolation<CreateProductCommand>> violations = validator.validate(command);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<CreateProductCommand> violation : violations) {
                throw new ConstraintViolationException("Error: " + violation.getMessage(), violations);
            }
        }
    }
}
