package com.perfumeOnlineStore.controller.orderItem.command.createOrderItemCommand;

import com.perfumeOnlineStore.controller.order.command.createOrderCommand.CreateOrderCommand;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class CreateOrderItemCommandValidator {
    private final Validator validator;

    public void validate(CreateOrderItemCommand command) {
        Set<ConstraintViolation<CreateOrderItemCommand>> violations = validator.validate(command);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<CreateOrderItemCommand> violation : violations) {
                throw new ConstraintViolationException("Error: " + violation.getMessage(), violations);
            }
        }
    }
}
