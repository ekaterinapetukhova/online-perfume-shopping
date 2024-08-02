package com.perfumeOnlineStore.controller.order.command.createOrderCommand;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@RequiredArgsConstructor
@Component
public class CreateOrderCommandValidator {
    private final Validator validator;

    public void validate(CreateOrderCommand command) {
        Set<ConstraintViolation<CreateOrderCommand>> violations = validator.validate(command);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<CreateOrderCommand> violation : violations) {
                throw new ConstraintViolationException("Error: " + violation.getMessage(), violations);
            }
        }
    }
}
