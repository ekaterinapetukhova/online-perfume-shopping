package com.perfumeOnlineStore.mapper.order;

import com.perfumeOnlineStore.controller.order.command.updateOrderCommand.UpdateOrderCommand;
import com.perfumeOnlineStore.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UpdateOrderCommandToOrderMapper {
    UpdateOrderCommandToOrderMapper INSTANCE = Mappers.getMapper(UpdateOrderCommandToOrderMapper.class);

    Order toOrder(UpdateOrderCommand command);
}
