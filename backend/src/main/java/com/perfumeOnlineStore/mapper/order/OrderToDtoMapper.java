package com.perfumeOnlineStore.mapper.order;

import com.perfumeOnlineStore.dto.OrderDto;
import com.perfumeOnlineStore.entity.Order;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderToDtoMapper {
    OrderToDtoMapper INSTANCE = Mappers.getMapper(OrderToDtoMapper.class);

    OrderDto toDto(Order order);

    @AfterMapping
    default void addTotalPriceToDto(Order order, OrderDto orderDto) {
        orderDto.setTotalPrice(order.getTotalPrice());
    }
}
