package com.perfumeOnlineStore.dto;

import com.perfumeOnlineStore.mapper.Default;
import lombok.*;

@Data
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
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
