package com.perfumeOnlineStore.dto;

import com.perfumeOnlineStore.entity.User;
import lombok.*;

import java.util.*;

@Data
public class UserDto {
    private UUID id;
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
