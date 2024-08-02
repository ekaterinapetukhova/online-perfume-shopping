package com.perfumeOnlineStore.controller.orderItem.command.deleteOrderItemCommand;

import com.perfumeOnlineStore.controller.order.command.deleteOrderCommand.DeleteOrderCommand;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@RequiredArgsConstructor
@Component
public class DeleteOrderItemCommandValidator {
    private final Validator validator;

    public void validate(DeleteOrderItemCommand command) {
        Set<ConstraintViolation<DeleteOrderItemCommand>> violations = validator.validate(command);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<DeleteOrderItemCommand> violation : violations) {
                throw new ConstraintViolationException("Error: " + violation.getMessage(), violations);
            }
        }
    }
}
