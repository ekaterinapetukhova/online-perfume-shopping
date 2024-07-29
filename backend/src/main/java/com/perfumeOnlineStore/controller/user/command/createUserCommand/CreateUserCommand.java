package com.perfumeOnlineStore.controller.user.command.createUserCommand;

import com.perfumeOnlineStore.mapper.Default;
import lombok.Data;

@Data
public class CreateUserCommand {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private String country;
    private String city;
    private String postcode;
}
