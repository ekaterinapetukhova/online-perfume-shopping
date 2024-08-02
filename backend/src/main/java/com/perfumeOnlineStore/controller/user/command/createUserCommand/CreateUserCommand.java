package com.perfumeOnlineStore.controller.user.command.createUserCommand;

import an.awesome.pipelinr.Command;
import com.perfumeOnlineStore.customValidators.uniqueEmail.UniqueEmail;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
public class CreateUserCommand implements Command<CreateUserCommandResponse> {
    @NotEmpty(message = "Name must be set")
    private String name;
    @NotEmpty(message = "Surname must be set")
    private String surname;
    @NotEmpty(message = "Email must be set")
    @UniqueEmail
    @Email
    private String email;
    @NotEmpty(message = "Password must be set")
    @Size(min = 8, max = 20, message = "Password length must be between 8 and 20 symbols")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])^[0-9a-zA-Z!@#$%^&*]{8,20}$",
            message = "Password must contain at least one small and capital Latin letter, number and special character (!, @, #, $, %, ^, &, *)")
    private String password;
    private String phoneNumber;
    private String address;
    private String country;
    private String city;
    private String postcode;
}
