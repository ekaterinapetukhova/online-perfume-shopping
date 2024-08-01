package com.perfumeOnlineStore.controller.product.command.deleteProductCommand;

import an.awesome.pipelinr.Command;
import com.perfumeOnlineStore.entity.Product;
import com.perfumeOnlineStore.repository.ProductRepository;
import com.perfumeOnlineStore.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DeleteProductCommandHandler implements Command.Handler<DeleteProductCommand, DeleteProductCommandResponse> {
    private final ProductService productService;
    private final DeleteProductCommandValidator validator;

    @Transactional
    @Override
    public DeleteProductCommandResponse handle(DeleteProductCommand command) {
        DeleteProductCommandResponse resp = new DeleteProductCommandResponse();

        try {
            validator.validate(command);

            Optional<Product> existingProduct = productService.findProductById(command.getProductId());

            if (existingProduct.isPresent()) {
                productService.deleteProduct(existingProduct.get());

                resp.setSuccess(true);
                resp.setStatus(HttpStatus.NO_CONTENT.name());
                resp.setStatusCode(HttpStatus.NO_CONTENT.value());
                resp.setPayload(existingProduct.get().getId());
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
