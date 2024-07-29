package com.perfumeOnlineStore.controller.product.query.allProductsQuery;

import com.perfumeOnlineStore.controller.response.ResponseBase;
import com.perfumeOnlineStore.dto.ProductDto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AllProductsQueryResponse extends ResponseBase<List<ProductDto>> {
    public AllProductsQueryResponse(List<ProductDto> payload) {
        super(payload);
    }
}