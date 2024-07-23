package com.perfumeOnlineStore.controller;

import com.perfumeOnlineStore.entity.Product;
import com.perfumeOnlineStore.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.findAllProducts();

        return !products.isEmpty() ? new ResponseEntity<>(products, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable("productId") Long productId) {
        Optional<Product> product = productService.findProductById(productId);

        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Product> createProduct(@RequestBody Product newProduct) {
        try {
            productService.saveProduct(newProduct);
            return new ResponseEntity<>(newProduct, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("productId") Long productId) {
        Optional<Product> existingProduct = productService.findProductById(productId);
        if (existingProduct.isPresent()) {
            productService.deleteProduct(existingProduct.get());
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
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
