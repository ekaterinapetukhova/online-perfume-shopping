package com.perfumeOnlineStore.mapper.product;

import com.perfumeOnlineStore.controller.product.command.updateProductCommand.UpdateProductCommand;
import com.perfumeOnlineStore.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UpdateProductCommandToProduct {
    UpdateProductCommandToProduct INSTANCE = Mappers.getMapper(UpdateProductCommandToProduct.class);

    Product toProduct(UpdateProductCommand command);
}
