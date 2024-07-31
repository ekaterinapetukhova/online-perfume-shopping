package com.perfumeOnlineStore.controller.product.command.deleteProductCommand;

import com.perfumeOnlineStore.controller.product.command.createProductCommand.CreateProductCommand;
import com.perfumeOnlineStore.customValidators.commandValidator.CommandValidator;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class DeleteProductCommandValidator implements CommandValidator<DeleteProductCommand, DeleteProductCommandResponse> {
    private final Validator validator;

    @Override
    public void validate(DeleteProductCommand command) {
        Set<ConstraintViolation<DeleteProductCommand>> violations = validator.validate(command);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<DeleteProductCommand> violation : violations) {
                throw new ConstraintViolationException("Error: " + violation.getMessage(), violations);
            }
        }
    }
}
