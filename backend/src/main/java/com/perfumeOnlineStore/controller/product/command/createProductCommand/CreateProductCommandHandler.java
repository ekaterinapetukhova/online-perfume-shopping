package com.perfumeOnlineStore.controller.product.command.createProductCommand;

import com.perfumeOnlineStore.entity.Product;
import com.perfumeOnlineStore.mapper.product.CreateProductCommandToProductMapper;
import com.perfumeOnlineStore.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateProductCommandHandler {
    private final ProductService productService;
    private final CreateProductCommandValidator validator;

    @Transactional
    public CreateProductCommandResponse handle(CreateProductCommand command) {
        try {
            validator.validate(command);

            Product product = CreateProductCommandToProductMapper.INSTANCE.toProduct(command);

            productService.saveProduct(product);

            return new CreateProductCommandResponse(product.getId(), HttpStatus.CREATED.value());
        } catch (Exception e) {
            return new CreateProductCommandResponse(null, HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }
}
