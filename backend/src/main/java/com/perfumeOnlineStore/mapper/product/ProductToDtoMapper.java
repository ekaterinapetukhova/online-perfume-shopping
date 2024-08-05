package com.perfumeOnlineStore.mapper.product;

import com.perfumeOnlineStore.dto.ProductDto;
import com.perfumeOnlineStore.entity.Product;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductToDtoMapper {
    ProductToDtoMapper INSTANCE = Mappers.getMapper(ProductToDtoMapper.class);

    ProductDto toDto(Product product);

    @AfterMapping
    default void addDiscountsToDto(Product product, ProductDto productDto) {
        productDto.setDiscounts(product.getDiscounts());
    }

    @AfterMapping
    default void addOrderItemToDto(Product product, ProductDto productDto) {
        productDto.setOrderItems(product.getOrderItems());
    }
}
