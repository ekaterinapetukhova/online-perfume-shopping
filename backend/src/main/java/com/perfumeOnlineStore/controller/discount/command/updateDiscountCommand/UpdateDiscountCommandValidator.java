package com.perfumeOnlineStore.controller.discount.command.updateDiscountCommand;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@RequiredArgsConstructor
@Component
public class UpdateDiscountCommandValidator {
    private final Validator validator;

    public void validate(UpdateDiscountCommand command) {
        Set<ConstraintViolation<UpdateDiscountCommand>> violations = validator.validate(command);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<UpdateDiscountCommand> violation : violations) {
                throw new ConstraintViolationException("Error: " + violation.getMessage(), violations);
            }
        }
    }
}
