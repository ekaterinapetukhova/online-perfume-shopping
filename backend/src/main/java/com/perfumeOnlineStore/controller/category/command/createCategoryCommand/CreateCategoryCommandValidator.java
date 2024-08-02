package com.perfumeOnlineStore.controller.category.command.createCategoryCommand;

import jakarta.validation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@RequiredArgsConstructor
@Component
public class CreateCategoryCommandValidator {
    private final Validator validator;

    public void validate(CreateCategoryCommand command) {
        Set<ConstraintViolation<CreateCategoryCommand>> violations = validator.validate(command);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<CreateCategoryCommand> violation : violations) {
                throw new ConstraintViolationException("Error: " + violation.getMessage(), violations);
            }
        }
    }

}
