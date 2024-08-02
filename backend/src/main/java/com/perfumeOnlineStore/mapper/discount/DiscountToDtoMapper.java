package com.perfumeOnlineStore.mapper.discount;

import com.perfumeOnlineStore.dto.DiscountDto;
import com.perfumeOnlineStore.entity.Discount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DiscountToDtoMapper {
    DiscountToDtoMapper INSTANCE = Mappers.getMapper(DiscountToDtoMapper.class);

    DiscountDto toDto(Discount discount);
}
