package com.perfumeOnlineStore.mapper.product;

import com.perfumeOnlineStore.controller.product.command.updateProductCommand.UpdateProductCommand;
import com.perfumeOnlineStore.entity.Product;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper
public interface Mapper {
    Mapper INSTANCE = Mappers.getMapper(Mapper.class);

    Product toProduct(UpdateProductCommand command);
}
