package com.perfumeOnlineStore.mapper.discount;

import com.perfumeOnlineStore.controller.discount.command.createDiscountCommand.CreateDiscountCommand;
import com.perfumeOnlineStore.entity.Discount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CreateDiscountCommandToDiscountMapper {
    CreateDiscountCommandToDiscountMapper INSTANCE = Mappers.getMapper(CreateDiscountCommandToDiscountMapper.class);

    Discount toDiscount(CreateDiscountCommand command);
}
