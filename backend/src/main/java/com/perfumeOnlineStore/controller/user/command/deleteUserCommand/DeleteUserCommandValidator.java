package com.perfumeOnlineStore.controller.user.command.deleteUserCommand;

import com.perfumeOnlineStore.controller.product.command.deleteProductCommand.DeleteProductCommand;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@RequiredArgsConstructor
@Component
public class DeleteUserCommandValidator {
    private final Validator validator;

    public void validate(DeleteUserCommand command) {
        Set<ConstraintViolation<DeleteUserCommand>> violations = validator.validate(command);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<DeleteUserCommand> violation : violations) {
                throw new ConstraintViolationException("Error: " + violation.getMessage(), violations);
            }
        }
    }
}
