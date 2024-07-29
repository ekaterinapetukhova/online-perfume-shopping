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

    public AllProductsQueryResponse getAllProducts() {
        List<Product> products = productService.findAllProducts();

        List<ProductDto> productsDto = products.stream()
                .map(ProductToDtoMapper.INSTANCE::toDto)
                .collect(Collectors.toList());

        return new AllProductsQueryResponse(productsDto, HttpStatus.OK.value());
    }
}
