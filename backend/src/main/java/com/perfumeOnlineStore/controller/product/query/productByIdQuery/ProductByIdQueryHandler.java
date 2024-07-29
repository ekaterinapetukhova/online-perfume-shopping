package com.perfumeOnlineStore.controller.product.query.productByIdQuery;

import com.perfumeOnlineStore.controller.response.ResponseBase;
import com.perfumeOnlineStore.controller.response.error.notFound.NotFoundErrorResponse;
import com.perfumeOnlineStore.dto.ProductDto;
import com.perfumeOnlineStore.entity.Product;
import com.perfumeOnlineStore.mapper.product.ProductToDtoMapper;
import com.perfumeOnlineStore.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductByIdQueryHandler {
    private final ProductService productService;

    public ResponseBase<?> getProductById(Long productId) {
        Optional<Product> product = productService.findProductById(productId);

        if (product.isPresent()) {
            ProductDto productDto = product.map(ProductToDtoMapper.INSTANCE::toDto).get();

            return new ProductByIdQueryResponse(productDto);
        } else {
            return new NotFoundErrorResponse();
        }
    }
}
