package com.perfumeOnlineStore.mapper.discount;

import com.perfumeOnlineStore.controller.discount.command.updateDiscountCommand.UpdateDiscountCommand;
import com.perfumeOnlineStore.entity.Discount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UpdateDiscountCommandToDiscountMapper {
    UpdateDiscountCommandToDiscountMapper INSTANCE = Mappers.getMapper(UpdateDiscountCommandToDiscountMapper.class);

    Discount toDiscount(UpdateDiscountCommand command);
}
