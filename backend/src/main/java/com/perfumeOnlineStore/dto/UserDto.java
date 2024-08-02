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
}
