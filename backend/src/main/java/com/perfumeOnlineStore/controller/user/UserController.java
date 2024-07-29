package com.perfumeOnlineStore.controller.user;

import com.perfumeOnlineStore.controller.user.command.createUserCommand.CreateUserCommand;
import com.perfumeOnlineStore.controller.user.command.createUserCommand.CreateUserCommandHandler;
import com.perfumeOnlineStore.controller.user.command.createUserCommand.CreateUserCommandResponse;
import com.perfumeOnlineStore.controller.user.query.getAllUsersQuery.GetAllUsersQueryHandler;
import com.perfumeOnlineStore.controller.user.query.getAllUsersQuery.GetAllUsersQueryResponse;
import com.perfumeOnlineStore.controller.user.query.getUserByIdQuery.GetUserByIdQueryHandler;
import com.perfumeOnlineStore.controller.user.query.getUserByIdQuery.GetUserByIdQueryResponse;
import com.perfumeOnlineStore.entity.User;
import com.perfumeOnlineStore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    private final CreateUserCommandHandler createUserCommandHandler;

    @GetMapping
    public GetAllUsersQueryResponse getAllUsers() {
        return getAllUsersQueryHandler.handle();
    }

    @GetMapping("/{userId}")
    public GetUserByIdQueryResponse getUserById(@PathVariable("userId") Long userId) {
        return getUserByIdQueryHandler.handle(userId);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CreateUserCommandResponse createUser(@RequestBody CreateUserCommand createUserCommand) {
        return createUserCommandHandler.handle(createUserCommand);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<HttpStatus> deleteUserById(@PathVariable("userId") Long userId) {
        Optional<User> existingUser = userService.findUserById(userId);
        if (existingUser.isPresent()) {
            userService.deleteUser(existingUser.get());
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
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
