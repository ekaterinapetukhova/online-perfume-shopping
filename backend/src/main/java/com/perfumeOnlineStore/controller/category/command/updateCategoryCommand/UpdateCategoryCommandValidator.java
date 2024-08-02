package com.perfumeOnlineStore.controller.category.command.updateCategoryCommand;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@RequiredArgsConstructor
@Component
public class UpdateCategoryCommandValidator {
    private final Validator validator;

    public void validate(UpdateCategoryCommand command) {
        Set<ConstraintViolation<UpdateCategoryCommand>> violations = validator.validate(command);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<UpdateCategoryCommand> violation : violations) {
                throw new ConstraintViolationException("Error: " + violation.getMessage(), violations);
            }
        }
    }
}
