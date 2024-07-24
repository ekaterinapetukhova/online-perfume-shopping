package com.perfumeOnlineStore.controller.product.query.productByIdQuery;

import com.perfumeOnlineStore.dto.ProductDto;
import org.springframework.http.HttpStatus;

public record ProductByIdQueryResponse(ProductDto productDto, HttpStatus httpStatus) {
}
