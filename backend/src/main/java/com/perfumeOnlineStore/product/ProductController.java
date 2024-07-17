package com.perfumeOnlineStore.product;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.rmi.ServerException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.findAllProducts();

        return ResponseEntity.ok(products);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable("productId") Long productId) {
        Optional<Product> product = productService.findProductById(productId);

        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Product> createProduct(@RequestBody Product newProduct,
                                                 HttpServletRequest request) throws ServerException {
        Product product = productService.saveProduct(newProduct);

        if (product != null) {
            URI location = ServletUriComponentsBuilder.fromRequestUri(request)
                    .path("/{productId}")
                    .buildAndExpand(product.getId())
                    .toUri();
            return ResponseEntity.created(location).body(product);
        } else throw new ServerException("Error in creating the Product resource. Try Again.");
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable("productId") Long productId) {
        Optional<Product> existingProduct = productService.findProductById(productId);
        if (existingProduct.isPresent()) {
            productService.deleteProduct(existingProduct.get());
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{productId}")
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
