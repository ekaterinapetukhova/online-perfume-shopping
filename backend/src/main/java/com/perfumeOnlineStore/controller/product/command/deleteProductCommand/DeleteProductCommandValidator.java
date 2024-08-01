package com.perfumeOnlineStore.controller.product.command.deleteProductCommand;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

//@RequiredArgsConstructor
//@Component
//public class DeleteProductCommandValidator {
//    private final Validator validator;
//
//    public void validate(DeleteProductCommand command) {
//        Set<ConstraintViolation<DeleteProductCommand>> violations = validator.validate(command);
//
//        if (!violations.isEmpty()) {
//            for (ConstraintViolation<DeleteProductCommand> violation : violations) {
//                throw new ConstraintViolationException("Error: " + violation.getMessage(), violations);
//            }
//        }
//    }
//}
