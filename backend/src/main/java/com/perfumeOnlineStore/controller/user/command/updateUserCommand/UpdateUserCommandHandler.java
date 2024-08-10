package com.perfumeOnlineStore.controller.user.command.updateUserCommand;

import an.awesome.pipelinr.Command;
import com.perfumeOnlineStore.entity.User;
import com.perfumeOnlineStore.mapper.user.UpdateUserCommandToUserMapper;
import com.perfumeOnlineStore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UpdateUserCommandHandler implements Command.Handler<UpdateUserCommand, UpdateUserCommandResponse> {
    private final UserService userService;
    private final UpdateUserCommandValidator validator;
    private final PasswordEncoder passwordEncoder;

    public UpdateUserCommandResponse handle(UpdateUserCommand command) {
        UpdateUserCommandResponse resp = new UpdateUserCommandResponse();

        validator.validate(command);

        try {
            Optional<User> existingUser = userService.findUserById(command.getId());

            if (existingUser.isPresent()) {
                User user = UpdateUserCommandToUserMapper.INSTANCE.toUser(command);
                user.setPassword(passwordEncoder.encode(command.getPassword()));

                userService.saveUser(user);

                resp.setSuccess(true);
                resp.setStatus(HttpStatus.OK.name());
                resp.setStatusCode(HttpStatus.OK.value());
                resp.setPayload(user);
            } else {
                resp.setStatus(HttpStatus.NOT_FOUND.name());
                resp.setStatusCode(HttpStatus.NOT_FOUND.value());
                resp.setPayload(null);
            }

            return resp;
        } catch (Exception e) {
            return resp;
        }
    }
}
