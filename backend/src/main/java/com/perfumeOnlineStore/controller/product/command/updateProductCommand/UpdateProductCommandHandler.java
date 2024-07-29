package com.perfumeOnlineStore.controller.product.command.updateProductCommand;

import com.perfumeOnlineStore.entity.Product;
import com.perfumeOnlineStore.mapper.product.UpdateProductCommandToProduct;
import com.perfumeOnlineStore.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateProductCommandHandler {
    private final ProductService productService;
    private final UpdateProductCommandValidator validator;

    public UpdateProductCommandResponse handle(UpdateProductCommand command) {
        try {
            validator.validate(command);

            Optional<Product> existingProduct = productService.findProductById(command.getId());

            if (existingProduct.isPresent()) {
                Product product = UpdateProductCommandToProduct.INSTANCE.toProduct(command);

                productService.saveProduct(product);

                return new UpdateProductCommandResponse(product.getId(), HttpStatus.OK.value());
            } else return new UpdateProductCommandResponse(null, HttpStatus.NOT_FOUND.value());
        } catch (Exception e) {
            return new UpdateProductCommandResponse(null, HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }
}
