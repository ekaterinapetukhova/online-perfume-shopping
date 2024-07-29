package com.perfumeOnlineStore.mapper.product;

import com.perfumeOnlineStore.dto.ProductDto;
import com.perfumeOnlineStore.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductToDtoMapper {
    ProductToDtoMapper INSTANCE = Mappers.getMapper(ProductToDtoMapper.class);

    ProductDto toDto(Product product);
    Product toEntity(ProductDto productDto);
}
