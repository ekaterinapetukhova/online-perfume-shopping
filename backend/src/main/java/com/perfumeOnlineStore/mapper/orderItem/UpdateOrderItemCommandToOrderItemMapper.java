package com.perfumeOnlineStore.mapper.orderItem;

import com.perfumeOnlineStore.controller.orderItem.command.updateOrderItemCommand.UpdateOrderItemCommand;
import com.perfumeOnlineStore.entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UpdateOrderItemCommandToOrderItemMapper {
    UpdateOrderItemCommandToOrderItemMapper INSTANCE = Mappers.getMapper(UpdateOrderItemCommandToOrderItemMapper.class);

    OrderItem toOrderItem(UpdateOrderItemCommand command);
}
