package com.perfumeOnlineStore.controller.product.command.createProductCommand;

import an.awesome.pipelinr.Command;
import com.perfumeOnlineStore.entity.Product;
import com.perfumeOnlineStore.mapper.product.CreateProductCommandToProductMapper;
import com.perfumeOnlineStore.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@RequiredArgsConstructor
public class CreateProductCommandHandler implements Command.Handler<CreateProductCommand, CreateProductCommandResponse> {
    private final ProductService productService;
//    private final CreateProductCommandValidator validator;

    @Override
    @Transactional
    public CreateProductCommandResponse handle(CreateProductCommand command) {
        CreateProductCommandResponse resp = new CreateProductCommandResponse();

        try {
//            validator.validate(command);

            Product product = CreateProductCommandToProductMapper.INSTANCE.toProduct(command);

            productService.saveProduct(product);

            resp.setSuccess(true);
            resp.setStatusCode(HttpStatus.CREATED.value());
            resp.setStatus(HttpStatus.CREATED.name());
            resp.setPayload(product);

            return resp;
        } catch (Exception e) {
            return resp;
        }
    }
}
