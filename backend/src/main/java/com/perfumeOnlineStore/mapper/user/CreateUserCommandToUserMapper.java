package com.perfumeOnlineStore.mapper.user;

import com.perfumeOnlineStore.controller.user.command.createUserCommand.CreateUserCommand;
import com.perfumeOnlineStore.entity.User;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = "spring")
public interface CreateUserCommandToUserMapper {
    CreateUserCommandToUserMapper INSTANCE = Mappers.getMapper(CreateUserCommandToUserMapper.class);

    @Mapping(target = "password", ignore = true)
    User toUser(CreateUserCommand command);
}
