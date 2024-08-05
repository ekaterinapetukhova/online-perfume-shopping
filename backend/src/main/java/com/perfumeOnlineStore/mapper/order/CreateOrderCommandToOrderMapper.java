package com.perfumeOnlineStore.mapper.order;

import com.perfumeOnlineStore.controller.order.command.createOrderCommand.CreateOrderCommand;
import com.perfumeOnlineStore.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CreateOrderCommandToOrderMapper {
    CreateOrderCommandToOrderMapper INSTANCE = Mappers.getMapper(CreateOrderCommandToOrderMapper.class);

    Order toOrder(CreateOrderCommand createOrderCommand);
}
