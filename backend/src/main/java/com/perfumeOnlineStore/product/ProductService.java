package com.perfumeOnlineStore.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }
}
