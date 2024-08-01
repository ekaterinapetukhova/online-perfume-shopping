package com.perfumeOnlineStore.controller.product;

import an.awesome.pipelinr.Pipeline;
import com.perfumeOnlineStore.controller.product.command.createProductCommand.*;
import com.perfumeOnlineStore.controller.product.command.deleteProductCommand.*;
import com.perfumeOnlineStore.controller.product.command.updateProductCommand.*;
import com.perfumeOnlineStore.controller.product.query.allProductsQuery.AllProductsQueryHandler;
import com.perfumeOnlineStore.controller.product.query.allProductsQuery.AllProductsQueryResponse;
import com.perfumeOnlineStore.controller.product.query.productByIdQuery.ProductByIdQueryHandler;
import com.perfumeOnlineStore.controller.product.query.productByIdQuery.ProductByIdQueryResponse;
import com.perfumeOnlineStore.controller.response.ResponseBase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final AllProductsQueryHandler allProductsQueryHandler;
    private final ProductByIdQueryHandler productByIdQueryHandler;
    private final Pipeline pipeline;

    @GetMapping
    public AllProductsQueryResponse getAllProducts() {
        return allProductsQueryHandler.handler();
    }

    @GetMapping("/{productId}")
    public ProductByIdQueryResponse getProductById(@PathVariable("productId") Long id) {
        return productByIdQueryHandler.handler(id);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CreateProductCommandResponse createProduct(@RequestBody CreateProductCommand createCommand) {
        return createCommand.execute(pipeline);
    }

    @DeleteMapping("/{productId}")
    public DeleteProductCommandResponse deleteProduct(@PathVariable("productId") Long id) {
        DeleteProductCommand deleteCommand = new DeleteProductCommand(id);

        return deleteCommand.execute(pipeline);
    }

    @PutMapping(
            value = "/{productId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public UpdateProductCommandResponse updateProductById(@PathVariable("productId") Long id,
                                                          @RequestBody UpdateProductCommand updateCommand) {
        updateCommand.setId(id);
        return updateCommand.execute(pipeline);
    }
}
