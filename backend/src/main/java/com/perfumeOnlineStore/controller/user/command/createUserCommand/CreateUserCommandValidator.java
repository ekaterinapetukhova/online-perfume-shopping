package com.perfumeOnlineStore.controller.user.command.createUserCommand;

import com.perfumeOnlineStore.controller.product.command.createProductCommand.CreateProductCommand;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class CreateUserCommandValidator {
    private final Validator validator;

    public void validate(CreateUserCommand command) {
        Set<ConstraintViolation<CreateUserCommand>> violations = validator.validate(command);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<CreateUserCommand> violation : violations) {
                throw new ConstraintViolationException("Error: " + violation.getMessage(), violations);
            }
        }
    }
}
