package com.perfumeOnlineStore.controller.product.command.deleteProductCommand;

import com.perfumeOnlineStore.entity.Product;
import com.perfumeOnlineStore.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeleteProductCommandHandler {
    private final ProductService productService;
    private final DeleteProductCommandValidator validator;

    public DeleteProductCommandResponse handle(DeleteProductCommand command) {
        try {
            validator.validate(command);

            Optional<Product> existingProduct = productService.findProductById(command.getProductId());

            if (existingProduct.isPresent()) {
                productService.deleteProduct(existingProduct.get());

                return new DeleteProductCommandResponse(existingProduct.get().getId(), HttpStatus.NO_CONTENT);
            } else {
                return new DeleteProductCommandResponse(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new DeleteProductCommandResponse(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
