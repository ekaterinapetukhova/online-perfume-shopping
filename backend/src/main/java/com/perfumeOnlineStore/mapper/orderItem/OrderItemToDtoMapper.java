package com.perfumeOnlineStore.mapper.orderItem;

import com.perfumeOnlineStore.dto.OrderItemDto;
import com.perfumeOnlineStore.entity.OrderItem;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderItemToDtoMapper {
    OrderItemToDtoMapper INSTANCE = Mappers.getMapper(OrderItemToDtoMapper.class);

    OrderItemDto toDto(OrderItem orderItem);
}
