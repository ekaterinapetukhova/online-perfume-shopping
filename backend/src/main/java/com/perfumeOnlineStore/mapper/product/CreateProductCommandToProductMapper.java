package com.perfumeOnlineStore.mapper.product;

import com.perfumeOnlineStore.controller.product.command.createProductCommand.CreateProductCommand;
import com.perfumeOnlineStore.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CreateProductCommandToProductMapper {
    CreateProductCommandToProductMapper INSTANCE = Mappers.getMapper(CreateProductCommandToProductMapper.class);

    Product toProduct(CreateProductCommand command);
}
