package com.perfumeOnlineStore.controller.discount.command.deleteDiscountCommand;

import com.perfumeOnlineStore.controller.user.command.deleteUserCommand.DeleteUserCommand;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@RequiredArgsConstructor
@Component
public class DeleteDiscountCommandValidator {
    private final Validator validator;

    public void validate(DeleteDiscountCommand command) {
        Set<ConstraintViolation<DeleteDiscountCommand>> violations = validator.validate(command);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<DeleteDiscountCommand> violation : violations) {
                throw new ConstraintViolationException("Error: " + violation.getMessage(), violations);
            }
        }
    }
}
