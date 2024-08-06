package com.perfumeOnlineStore.mapper.userWithProducts;

import com.perfumeOnlineStore.dto.UserWithProductsDto;
import com.perfumeOnlineStore.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserWithProductsToDtoMapper {
    UserWithProductsToDtoMapper INSTANCE = Mappers.getMapper(UserWithProductsToDtoMapper.class);

    UserWithProductsDto toDto(User user);
}
