package com.perfumeOnlineStore.controller.user;

import an.awesome.pipelinr.Pipeline;
import com.perfumeOnlineStore.controller.user.command.createUserCommand.*;
import com.perfumeOnlineStore.controller.user.command.deleteUserCommand.*;
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
        DeleteUserCommand command = new DeleteUserCommand(id);

        return command.execute(pipeline);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUserById(@PathVariable("userId") Long userId,
                                               @RequestBody User updatedUser) {
        Optional<User> existingUser = userService.findUserById(userId);

        if (existingUser.isPresent()) {
            User user = existingUser.get();

            user.setName(updatedUser.getName());
            user.setCity(updatedUser.getCity());
            user.setAddress(updatedUser.getAddress());
            user.setCountry(updatedUser.getCountry());
            user.setPhoneNumber(updatedUser.getPhoneNumber());
            user.setPostcode(updatedUser.getPostcode());
            user.setPassword(updatedUser.getPassword());
            user.setSurname(updatedUser.getSurname());
            user.setEmail(updatedUser.getEmail());

            userService.saveUser(user);
            return ResponseEntity.ok(user);
        } else return ResponseEntity.notFound().build();
    }
}
