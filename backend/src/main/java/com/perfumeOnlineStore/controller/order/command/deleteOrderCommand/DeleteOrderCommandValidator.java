package com.perfumeOnlineStore.controller.order.command.deleteOrderCommand;

import jakarta.validation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@RequiredArgsConstructor
@Component
public class DeleteOrderCommandValidator {
    private final Validator validator;

    public void validate(DeleteOrderCommand command) {
        Set<ConstraintViolation<DeleteOrderCommand>> violations = validator.validate(command);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<DeleteOrderCommand> violation : violations) {
                throw new ConstraintViolationException("Error: " + violation.getMessage(), violations);
            }
        }
    }
}
