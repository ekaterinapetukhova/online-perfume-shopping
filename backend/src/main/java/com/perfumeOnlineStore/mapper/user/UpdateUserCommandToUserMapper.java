package com.perfumeOnlineStore.mapper.user;

import com.perfumeOnlineStore.controller.user.command.updateUserCommand.UpdateUserCommand;
import com.perfumeOnlineStore.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UpdateUserCommandToUserMapper {
    UpdateUserCommandToUserMapper INSTANCE = Mappers.getMapper(UpdateUserCommandToUserMapper.class);

    @Mapping(target = "password", ignore = true)
    User toUser(UpdateUserCommand command);
}
