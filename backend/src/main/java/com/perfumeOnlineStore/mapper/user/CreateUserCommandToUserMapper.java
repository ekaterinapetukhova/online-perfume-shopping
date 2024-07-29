package com.perfumeOnlineStore.mapper.user;

import com.perfumeOnlineStore.controller.user.command.createUserCommand.CreateUserCommand;
import com.perfumeOnlineStore.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CreateUserCommandToUserMapper {
    CreateUserCommandToUserMapper INSTANCE = Mappers.getMapper(CreateUserCommandToUserMapper.class);

    User toUser(CreateUserCommand command);
}
