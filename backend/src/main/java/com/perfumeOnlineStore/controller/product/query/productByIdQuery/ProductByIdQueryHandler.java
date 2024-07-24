package com.perfumeOnlineStore.controller.product.query.productByIdQuery;

import com.perfumeOnlineStore.dto.ProductDto;
import com.perfumeOnlineStore.entity.Product;
import com.perfumeOnlineStore.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductByIdQueryHandler {
    private final ProductService productService;

    public ProductByIdQueryResponse getProductById(Long productId) {
        Optional<Product> product = productService.findProductById(productId);

        if (product.isPresent()) {
            ProductDto productDto = product.map(value -> new ProductDto(
                    value.getName(),
                    value.getDescription(),
                    value.getBrand(),
                    value.getPrice(),
                    value.getComponents(),
                    value.getScentGroups(),
                    value.getQuantity(),
                    value.getGender(),
                    value.getVolume()
            ))
                    .get();

            return new ProductByIdQueryResponse(productDto, HttpStatus.OK);
        } else {
            return new ProductByIdQueryResponse(null, HttpStatus.NOT_FOUND);
        }
    }
}
