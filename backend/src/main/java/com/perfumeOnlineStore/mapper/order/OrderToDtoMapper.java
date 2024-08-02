package com.perfumeOnlineStore.mapper.order;

import com.perfumeOnlineStore.dto.OrderDto;
import com.perfumeOnlineStore.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderToDtoMapper {
    OrderToDtoMapper INSTANCE = Mappers.getMapper(OrderToDtoMapper.class);

    OrderDto toDto(Order order);
}
