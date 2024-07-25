package com.perfumeOnlineStore.controller.product.command.deleteProductCommand;

import org.springframework.stereotype.Component;

@Component
public class DeleteProductCommandValidator {
    public void validate(DeleteProductCommand command) {
        if (command.getProductId() == null) throw new IllegalArgumentException("Product's ID isn't specified");
    }
}
