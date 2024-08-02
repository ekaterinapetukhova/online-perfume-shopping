package com.perfumeOnlineStore.controller.category.command.deleteCategoryCommand;

import jakarta.validation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@RequiredArgsConstructor
@Component
public class DeleteCategoryCommandValidator {
    private final Validator validator;

    public void validate(DeleteCategoryCommand command) {
        Set<ConstraintViolation<DeleteCategoryCommand>> violations = validator.validate(command);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<DeleteCategoryCommand> violation : violations) {
                throw new ConstraintViolationException("Error: " + violation.getMessage(), violations);
            }
        }
    }
}
