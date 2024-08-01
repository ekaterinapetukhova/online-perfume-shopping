package com.perfumeOnlineStore.controller.user;

import an.awesome.pipelinr.Pipeline;
import com.perfumeOnlineStore.controller.user.command.createUserCommand.*;
import com.perfumeOnlineStore.controller.user.command.deleteUserCommand.*;
import com.perfumeOnlineStore.controller.user.command.updateUserCommand.UpdateUserCommand;
import com.perfumeOnlineStore.controller.user.command.updateUserCommand.UpdateUserCommandResponse;
import com.perfumeOnlineStore.controller.user.query.getAllUsersQuery.*;
import com.perfumeOnlineStore.controller.user.query.getUserByIdQuery.*;
import com.perfumeOnlineStore.entity.User;
import com.perfumeOnlineStore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final GetAllUsersQueryHandler getAllUsersQueryHandler;
    private final GetUserByIdQueryHandler getUserByIdQueryHandler;
    private final Pipeline pipeline;

    @GetMapping
    public GetAllUsersQueryResponse getAllUsers() {
        return getAllUsersQueryHandler.handle();
    }

    @GetMapping("/{userId}")
    public GetUserByIdQueryResponse getUserById(@PathVariable("userId") Long id) {
        return getUserByIdQueryHandler.handle(id);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CreateUserCommandResponse createUser(@RequestBody CreateUserCommand createCommand) {
        return createCommand.execute(pipeline);
    }

    @DeleteMapping("/{userId}")
    public DeleteUserCommandResponse deleteUserById(@PathVariable("userId") Long id) {
        DeleteUserCommand deleteCommand = new DeleteUserCommand(id);

        return deleteCommand.execute(pipeline);
    }

    @PutMapping("/{userId}")
    public UpdateUserCommandResponse updateUserById(@PathVariable("userId") Long id,
                                                    @RequestBody UpdateUserCommand updateCommand) {
        updateCommand.setId(id);

        return updateCommand.execute(pipeline);
    }
}
