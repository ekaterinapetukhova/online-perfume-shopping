package com.perfumeOnlineStore.mapper.user;

import com.perfumeOnlineStore.dto.UserDto;
import com.perfumeOnlineStore.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserToDtoMapper {
    UserToDtoMapper INSTANCE = Mappers.getMapper(UserToDtoMapper.class);

    UserDto toDto(User user);
}
