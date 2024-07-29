package com.perfumeOnlineStore.mapper.user;

import com.perfumeOnlineStore.dto.UserDto;
import com.perfumeOnlineStore.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserToUserDtoMapper {
    UserToUserDtoMapper INSTANCE = Mappers.getMapper(UserToUserDtoMapper.class);

    UserDto toDto(User user);
}
