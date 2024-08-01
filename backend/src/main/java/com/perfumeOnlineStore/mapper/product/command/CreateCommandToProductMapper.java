package com.perfumeOnlineStore.mapper.product.command;

import com.perfumeOnlineStore.controller.product.command.createProductCommand.CreateProductCommand;
import com.perfumeOnlineStore.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CreateCommandToProductMapper {
    CreateCommandToProductMapper INSTANCE = Mappers.getMapper(CreateCommandToProductMapper.class);

    CreateProductCommand toProduct(Product product);
}
