package com.perfumeOnlineStore.controller.product.query.allProductsQuery;

import com.perfumeOnlineStore.dto.ProductDto;

import org.springframework.http.HttpStatus;

import java.util.List;

public record AllProductsQueryResponse(List<ProductDto> products, HttpStatus responseStatus) {
}
