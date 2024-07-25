package com.perfumeOnlineStore.controller.product;

import com.perfumeOnlineStore.controller.product.command.createProductCommand.CreateProductCommand;
import com.perfumeOnlineStore.controller.product.command.createProductCommand.CreateProductCommandHandler;
import com.perfumeOnlineStore.controller.product.command.createProductCommand.CreateProductCommandResponse;
import com.perfumeOnlineStore.controller.product.command.deleteProductCommand.DeleteProductCommand;
import com.perfumeOnlineStore.controller.product.command.deleteProductCommand.DeleteProductCommandHandler;
import com.perfumeOnlineStore.controller.product.command.deleteProductCommand.DeleteProductCommandResponse;
import com.perfumeOnlineStore.controller.product.command.updateProductCommand.UpdateProductCommand;
import com.perfumeOnlineStore.controller.product.command.updateProductCommand.UpdateProductCommandHandler;
import com.perfumeOnlineStore.controller.product.command.updateProductCommand.UpdateProductCommandResponse;
import com.perfumeOnlineStore.controller.product.query.allProductsQuery.AllProductsQueryHandler;
import com.perfumeOnlineStore.controller.product.query.allProductsQuery.AllProductsQueryResponse;
import com.perfumeOnlineStore.controller.product.query.productByIdQuery.ProductByIdQueryHandler;
import com.perfumeOnlineStore.controller.product.query.productByIdQuery.ProductByIdQueryResponse;
import com.perfumeOnlineStore.entity.Product;
import com.perfumeOnlineStore.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final AllProductsQueryHandler allProductsQueryHandler;
    private final ProductByIdQueryHandler productByIdQueryHandler;
    private final CreateProductCommandHandler createProductCommandHandler;
    private final DeleteProductCommandHandler deleteProductCommandHandler;
    private final UpdateProductCommandHandler updateProductCommandHandler;

    @GetMapping
    public AllProductsQueryResponse getAllProducts() {
        return allProductsQueryHandler.getAllProducts();
    }

    @GetMapping("/{productId}")
    public ProductByIdQueryResponse getProductById(@PathVariable("productId") Long productId) {
        return productByIdQueryHandler.getProductById(productId);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CreateProductCommandResponse createProduct(@RequestBody CreateProductCommand createCommand) {
        return createProductCommandHandler.handle(createCommand);
    }

    @DeleteMapping("/{productId}")
    public DeleteProductCommandResponse deleteProduct(@PathVariable("productId") Long productId) {
        return deleteProductCommandHandler.handle(new DeleteProductCommand(productId));
    }

    @PutMapping(
            value = "/{productId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public UpdateProductCommandResponse updateProductById(@PathVariable("productId") Long productId,
                                                          @RequestBody UpdateProductCommand updateCommand) {
        updateCommand.setId(productId);
        return updateProductCommandHandler.handle(updateCommand);
    }
}
