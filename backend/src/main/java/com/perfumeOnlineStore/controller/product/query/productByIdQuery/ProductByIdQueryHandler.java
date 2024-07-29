package com.perfumeOnlineStore.controller.product.query.productByIdQuery;

import com.perfumeOnlineStore.dto.ProductDto;
import com.perfumeOnlineStore.entity.Product;
import com.perfumeOnlineStore.mapper.product.ProductToDtoMapper;
import com.perfumeOnlineStore.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductByIdQueryHandler {
    private final ProductService productService;

    public ProductByIdQueryResponse getProductById(Long productId) {
        Optional<Product> product = productService.findProductById(productId);

        if (product.isPresent()) {
            ProductDto productDto = product.map(ProductToDtoMapper.INSTANCE::toDto).get();

            return new ProductByIdQueryResponse(productDto, HttpStatus.OK.value());
        } else {
            return new ProductByIdQueryResponse(null, HttpStatus.NOT_FOUND.value());
        }
    }
}
