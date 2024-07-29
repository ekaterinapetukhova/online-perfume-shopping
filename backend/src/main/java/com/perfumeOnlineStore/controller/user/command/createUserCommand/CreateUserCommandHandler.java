package com.perfumeOnlineStore.controller.user.command.createUserCommand;

import com.perfumeOnlineStore.dto.UserDto;
import com.perfumeOnlineStore.entity.User;
import com.perfumeOnlineStore.mapper.user.CreateUserCommandToUserMapper;
import com.perfumeOnlineStore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserCommandHandler {
    private final UserService userService;
    private final CreateUserCommandValidator validator;

    public CreateUserCommandResponse handle(CreateUserCommand command) {
        try {
            validator.validate(command);

            User user = CreateUserCommandToUserMapper.INSTANCE.toUser(command);

            userService.saveUser(user);

            return new CreateUserCommandResponse(user.getId(), HttpStatus.CREATED.value());
        } catch (Exception e) {
            return new CreateUserCommandResponse(null, HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }
}
