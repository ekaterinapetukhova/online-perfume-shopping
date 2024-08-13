package com.perfumeOnlineStore.controller.session.command.createSessionCommand;

import com.perfumeOnlineStore.controller.category.command.createCategoryCommand.CreateCategoryCommand;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@RequiredArgsConstructor
@Component
public class CreateSessionCommandValidator {
    private final Validator validator;

    public void validate(CreateSessionCommand command) {
        Set<ConstraintViolation<CreateSessionCommand>> violations = validator.validate(command);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<CreateSessionCommand> violation : violations) {
                throw new ConstraintViolationException("Error: " + violation.getMessage(), violations);
            }
        }
    }
}
