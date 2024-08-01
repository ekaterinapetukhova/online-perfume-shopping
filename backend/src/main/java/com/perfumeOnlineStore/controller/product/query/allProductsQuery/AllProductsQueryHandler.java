package com.perfumeOnlineStore.controller.product.query.allProductsQuery;

import com.perfumeOnlineStore.dto.ProductDto;
import com.perfumeOnlineStore.entity.Product;
import com.perfumeOnlineStore.mapper.product.ProductToDtoMapper;
import com.perfumeOnlineStore.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AllProductsQueryHandler {
    private final ProductService productService;

    public AllProductsQueryResponse handler() {
        AllProductsQueryResponse resp = new AllProductsQueryResponse();

        try {
            List<Product> products = productService.findAllProducts();

            List<ProductDto> productsDto = products.stream()
                    .map(ProductToDtoMapper.INSTANCE::toDto)
                    .collect(Collectors.toList());

            resp.setSuccess(true);
            resp.setStatusCode(HttpStatus.OK.value());
            resp.setStatus(HttpStatus.OK.name());
            resp.setPayload(productsDto);

            return resp;
        } catch (Exception e) {
            return resp;
        }
    }
}
