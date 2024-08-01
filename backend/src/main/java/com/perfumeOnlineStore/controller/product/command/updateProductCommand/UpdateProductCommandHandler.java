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
        UpdateProductCommandResponse resp = new UpdateProductCommandResponse();

        try {
            validator.validate(command);

            Optional<Product> existingProduct = productService.findProductById(command.getId());

            if (existingProduct.isPresent()) {
                Product product = UpdateProductCommandToProduct.INSTANCE.toProduct(command);

                productService.saveProduct(product);

                resp.setSuccess(true);
                resp.setStatus(HttpStatus.OK.name());
                resp.setStatusCode(HttpStatus.OK.value());
                resp.setPayload(product);
            } else {
                resp.setStatus(HttpStatus.NOT_FOUND.name());
                resp.setStatusCode(HttpStatus.NOT_FOUND.value());
                resp.setPayload(null);
            }

            return resp;
        } catch (Exception e) {
            return resp;
        }
    }
}
