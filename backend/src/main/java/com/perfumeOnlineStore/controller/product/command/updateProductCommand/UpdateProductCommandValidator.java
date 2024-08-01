package com.perfumeOnlineStore.controller.product.command.updateProductCommand;

import com.perfumeOnlineStore.controller.product.command.deleteProductCommand.DeleteProductCommand;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class UpdateProductCommandValidator {
    private final Validator validator;

    public void validate(UpdateProductCommand command) {
        Set<ConstraintViolation<UpdateProductCommand>> violations = validator.validate(command);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<UpdateProductCommand> violation : violations) {
                throw new ConstraintViolationException("Error: " + violation.getMessage(), violations);
            }
        }
    }
}
