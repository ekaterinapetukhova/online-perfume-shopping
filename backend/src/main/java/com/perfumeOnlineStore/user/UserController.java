package com.perfumeOnlineStore.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAllUsers();

        return ResponseEntity.ok(users);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") Long userId) {
        Optional<User> user = userService.findUserById(userId);

        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<User> createUser(@RequestBody User newUser) {
        try {
            userService.saveUser(newUser);
            return new ResponseEntity<>(newUser, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
