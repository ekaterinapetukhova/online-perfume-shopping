package com.perfumeOnlineStore.controller.user.command.createUserCommand;

import org.springframework.stereotype.Component;

@Component
public class CreateUserCommandValidator {
    public void validate(CreateUserCommand command) {
        if (command.getName() == null || command.getName().isEmpty()) throw new IllegalArgumentException("Name can't be empty");
        if (command.getPassword() == null || command.getPassword().isEmpty()) throw new IllegalArgumentException("Password can't be empty");
        if (command.getEmail() == null || command.getEmail().isEmpty()) throw new IllegalArgumentException("Email can't be empty");
        if (command.getSurname() == null || command.getSurname().isEmpty()) throw new IllegalArgumentException("Surname can't be empty");
     }
}
