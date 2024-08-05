package com.perfumeOnlineStore.mapper.orderItem;

import com.perfumeOnlineStore.controller.orderItem.command.createOrderItemCommand.CreateOrderItemCommand;
import com.perfumeOnlineStore.entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CreateOrderItemCommandToOrderItemMapper {
    CreateOrderItemCommandToOrderItemMapper INSTANCE = Mappers.getMapper(CreateOrderItemCommandToOrderItemMapper.class);

    OrderItem toOrderItem(CreateOrderItemCommand createOrderItemCommand);
}
