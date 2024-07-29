package com.perfumeOnlineStore.dto;

import com.perfumeOnlineStore.customValidators.uniqueEmail.UniqueEmail;
import com.perfumeOnlineStore.mapper.Default;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
public class UserDto {
    private Long id;
    @NotBlank(message = "Please enter your name")
    private String name;
    @NotBlank(message = "Please enter your surname")
    private String surname;
    @NotBlank(message = "Please enter your email")
    @Email(message = "Please provide a valid email address")
    @NotNull
    @UniqueEmail
    private String email;
    @NotBlank(message = "You must enter your password")
    @Size(min = 8, max = 20, message = "Password length must be between 8 and 20 symbols")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])^[0-9a-zA-Z!@#$%^&*]{8,20}$",
            message = "Password must contain at least one small and capital Latin letter, number and special character (!, @, #, $, %, ^, &, *)")
    private String password;
    private String phoneNumber;
    private String address;
    private String country;
    private String city;
    private String postcode;

    @Default
    public UserDto(
            String name,
            String surname,
            String email,
            String password,
            String phoneNumber,
            String address,
            String country,
            String city,
            String postcode
    ) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.country = country;
        this.city = city;
        this.postcode = postcode;
    }
}
