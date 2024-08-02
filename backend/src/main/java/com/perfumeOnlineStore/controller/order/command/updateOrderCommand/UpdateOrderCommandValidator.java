package com.perfumeOnlineStore.controller.order.command.updateOrderCommand;

import jakarta.validation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@RequiredArgsConstructor
@Component
public class UpdateOrderCommandValidator {
    private final Validator validator;

    public void validate(UpdateOrderCommand command) {
        Set<ConstraintViolation<UpdateOrderCommand>> violations = validator.validate(command);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<UpdateOrderCommand> violation : violations) {
                throw new ConstraintViolationException("Error: " + violation.getMessage(), violations);
            }
        }
    }
}
