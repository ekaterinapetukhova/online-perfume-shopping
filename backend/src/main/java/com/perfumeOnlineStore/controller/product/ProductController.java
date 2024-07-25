package com.perfumeOnlineStore.controller.product;

import com.perfumeOnlineStore.controller.product.command.createProductCommand.CreateProductCommand;
import com.perfumeOnlineStore.controller.product.command.createProductCommand.CreateProductCommandHandler;
import com.perfumeOnlineStore.controller.product.command.createProductCommand.CreateProductCommandResponse;
import com.perfumeOnlineStore.controller.product.command.deleteProductCommand.DeleteProductCommand;
import com.perfumeOnlineStore.controller.product.command.deleteProductCommand.DeleteProductCommandHandler;
import com.perfumeOnlineStore.controller.product.command.deleteProductCommand.DeleteProductCommandResponse;
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
    public CreateProductCommandResponse createProduct(@RequestBody CreateProductCommand command) {
        return createProductCommandHandler.handle(command);
    }

    @DeleteMapping("/{productId}")
    public DeleteProductCommandResponse deleteProduct(@PathVariable("productId") DeleteProductCommand command) {
        return deleteProductCommandHandler.handle(command);
    }

    @PutMapping(
            value = "/{productId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Product> updateProductById(@PathVariable("productId") Long productId,
                                               @RequestBody Product updatedProduct) {
        Optional<Product> existingProduct = productService.findProductById(productId);

        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();

            product.setName(updatedProduct.getName());
            product.setDescription(updatedProduct.getDescription());
            product.setPrice(updatedProduct.getPrice());
            product.setBrand(updatedProduct.getBrand());
            product.setComponents(updatedProduct.getComponents());
            product.setQuantity(updatedProduct.getQuantity());
            product.setVolume(updatedProduct.getVolume());
            product.setScentGroups(updatedProduct.getScentGroups());
            product.setGender(updatedProduct.getGender());

            productService.saveProduct(product);

            return ResponseEntity.ok(product);
        } else return ResponseEntity.notFound().build();
    }
}
