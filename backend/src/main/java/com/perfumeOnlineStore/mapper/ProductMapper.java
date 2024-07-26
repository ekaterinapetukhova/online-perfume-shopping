package com.perfumeOnlineStore.mapper;

import com.perfumeOnlineStore.dto.ProductDto;
import com.perfumeOnlineStore.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto toDto(Product product);
    Product toEntity(ProductDto productDto);
}
