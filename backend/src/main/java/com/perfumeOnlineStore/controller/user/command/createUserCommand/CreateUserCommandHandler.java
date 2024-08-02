package com.perfumeOnlineStore.controller.user.command.createUserCommand;

import an.awesome.pipelinr.Command;
import com.perfumeOnlineStore.dto.UserDto;
import com.perfumeOnlineStore.entity.User;
import com.perfumeOnlineStore.mapper.user.CreateUserCommandToUserMapper;
import com.perfumeOnlineStore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserCommandHandler implements Command.Handler<CreateUserCommand, CreateUserCommandResponse>{
    private final UserService userService;
    private final CreateUserCommandValidator validator;

    public CreateUserCommandResponse handle(CreateUserCommand command) {
        CreateUserCommandResponse resp = new CreateUserCommandResponse();

        validator.validate(command);

        try {
            User user = CreateUserCommandToUserMapper.INSTANCE.toUser(command);

            userService.saveUser(user);

            resp.setSuccess(true);
            resp.setStatusCode(HttpStatus.CREATED.value());
            resp.setStatus(HttpStatus.CREATED.name());
            resp.setPayload(user);

            return resp;
        } catch (Exception e) {
            return resp;
        }
    }
}
