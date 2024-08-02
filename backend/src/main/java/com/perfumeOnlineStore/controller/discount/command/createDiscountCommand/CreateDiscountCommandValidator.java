package com.perfumeOnlineStore.controller.discount.command.createDiscountCommand;

import jakarta.validation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@RequiredArgsConstructor
@Component
public class CreateDiscountCommandValidator {
    private final Validator validator;

    public void validate(CreateDiscountCommand command) {
        Set<ConstraintViolation<CreateDiscountCommand>> violations = validator.validate(command);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<CreateDiscountCommand> violation : violations) {
                throw new ConstraintViolationException("Error: " + violation.getMessage(), violations);
            }
        }
    }
}
