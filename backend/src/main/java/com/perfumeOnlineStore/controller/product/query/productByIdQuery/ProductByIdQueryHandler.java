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
        ProductByIdQueryResponse resp = new ProductByIdQueryResponse();

        try {
            Optional<Product> product = productService.findProductById(productId);

            if (product.isPresent()) {
                ProductDto productDto = product.map(ProductToDtoMapper.INSTANCE::toDto).get();

                resp.setSuccess(true);
                resp.setStatusCode(HttpStatus.OK.value());
                resp.setStatus(HttpStatus.OK.name());
                resp.setPayload(productDto);
            } else {
                resp.setStatusCode(HttpStatus.NOT_FOUND.value());
                resp.setStatus(HttpStatus.NOT_FOUND.name());
                resp.setPayload(null);
            }
            return resp;
        } catch (Exception e) {
            return resp;
        }
    }
}
