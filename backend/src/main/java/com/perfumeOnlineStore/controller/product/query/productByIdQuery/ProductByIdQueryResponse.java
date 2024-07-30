package com.perfumeOnlineStore.controller.product.query.productByIdQuery;

import com.perfumeOnlineStore.controller.response.ResponseBase;
import com.perfumeOnlineStore.dto.ProductDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProductByIdQueryResponse extends ResponseBase<ProductDto> {
    public ProductByIdQueryResponse(ProductDto payload) {
        super(payload);
    }
}
