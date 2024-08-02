package com.perfumeOnlineStore.controller.orderItem.command.updateOrderItemCommand;

import com.perfumeOnlineStore.controller.order.command.updateOrderCommand.UpdateOrderCommand;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class UpdateOrderItemCommandValidator {
    private final Validator validator;

    public void validate(UpdateOrderItemCommand command) {
        Set<ConstraintViolation<UpdateOrderItemCommand>> violations = validator.validate(command);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<UpdateOrderItemCommand> violation : violations) {
                throw new ConstraintViolationException("Error: " + violation.getMessage(), violations);
            }
        }
    }
}
