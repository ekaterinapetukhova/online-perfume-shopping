package com.perfumeOnlineStore.controller.product.createProductCommand;

import com.perfumeOnlineStore.entity.Product;
import com.perfumeOnlineStore.repository.ProductRepository;
import com.perfumeOnlineStore.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateProductCommandHandler {
    private final ProductRepository productRepository;
    private final CreateProductCommandValidator createProductCommandValidator;

    @Transactional
    public CreateProductCommandResponse handle(CreateProductCommand command) {
        try {
            createProductCommandValidator.validate(command);

            Product product = getProduct(command);

            productRepository.save(product);

            return new CreateProductCommandResponse(product.getId(), new ResponseEntity<>(product, HttpStatus.CREATED));
        } catch (Exception e) {
            return new CreateProductCommandResponse(null, new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    private static Product getProduct(CreateProductCommand command) {
        Product product = new Product();
        product.setName(command.getName());
        product.setDescription(command.getDescription());
        product.setBrand(command.getBrand());
        product.setPrice(command.getPrice());
        product.setComponents(command.getComponents());
        product.setScentGroups(command.getScentGroups());
        product.setGender(command.getGender());
        product.setVolume(command.getVolume());
        product.setQuantity(command.getQuantity());
        return product;
    }
}
