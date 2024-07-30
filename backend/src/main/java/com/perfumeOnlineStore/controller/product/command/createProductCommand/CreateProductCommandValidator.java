package com.perfumeOnlineStore.controller.product.command.createProductCommand;

import com.perfumeOnlineStore.customValidators.commandValidator.CommandValidator;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

@RequiredArgsConstructor
@Slf4j
public class CreateProductCommandValidator implements CommandValidator<CreateProductCommand, CreateProductCommandResponse> {
    private final Validator validator;

    @Override
    public void validate(CreateProductCommand command) {
        Set<ConstraintViolation<CreateProductCommand>> violations = validator.validate(command);

        log.info("VIOLATIONS: {}", violations);

        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();

            for (ConstraintViolation<CreateProductCommand> constraintViolation : violations) {
                sb.append(constraintViolation.getMessage());
            }
            throw new ConstraintViolationException("Error occurred: " + sb, violations);
        }
    }
}
