package com.perfumeOnlineStore.mapper.discount;

import com.perfumeOnlineStore.dto.DiscountDto;
import com.perfumeOnlineStore.entity.Discount;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DiscountToDtoMapper {
    DiscountToDtoMapper INSTANCE = Mappers.getMapper(DiscountToDtoMapper.class);

    DiscountDto toDto(Discount discount);

    @AfterMapping
    default void addProductsToDto(Discount discount, DiscountDto discountDto) {
        discountDto.setProducts(discount.getProducts());
    }
}
