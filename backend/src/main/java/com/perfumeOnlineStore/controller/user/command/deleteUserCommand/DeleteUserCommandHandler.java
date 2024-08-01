package com.perfumeOnlineStore.controller.user.command.deleteUserCommand;

import an.awesome.pipelinr.Command;
import com.perfumeOnlineStore.entity.User;
import com.perfumeOnlineStore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DeleteUserCommandHandler implements Command.Handler<DeleteUserCommand, DeleteUserCommandResponse>{
    private final UserService userService;

    @Override
    public DeleteUserCommandResponse handle(DeleteUserCommand deleteUserCommand) {
        DeleteUserCommandResponse resp = new DeleteUserCommandResponse();

        try {
            Optional<User> existingUser = userService.findUserById(deleteUserCommand.getId());

            if (existingUser.isPresent()) {
                userService.deleteUser(existingUser.get());

                resp.setSuccess(true);
                resp.setStatus(HttpStatus.NO_CONTENT.name());
                resp.setStatusCode(HttpStatus.NO_CONTENT.value());
                resp.setPayload(existingUser.get().getId());
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
