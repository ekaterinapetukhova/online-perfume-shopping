package com.perfumeOnlineStore.entity;

import com.fasterxml.jackson.annotation.*;
import com.perfumeOnlineStore.utils.encryption.aes.AesEncrypt;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Table
@Data
@NoArgsConstructor
@JsonIgnoreProperties(value = { "hibernateLazyInitializer" })
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Convert(converter = AesEncrypt.class)
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    @Convert(converter = AesEncrypt.class)
    private String surname;
    @Column(unique = true, nullable = false)
    @Convert(converter = AesEncrypt.class)
    private String email;
    @Column(nullable = false)
    private String password;
    @Convert(converter = AesEncrypt.class)
    private String phoneNumber;
    @Convert(converter = AesEncrypt.class)
    private String address;
    @Convert(converter = AesEncrypt.class)
    private String country;
    @Convert(converter = AesEncrypt.class)
    private String city;
    @Convert(converter = AesEncrypt.class)
    private String postcode;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    public enum Role {
        USER, ADMIN
    }

//    @ManyToMany(
//            fetch = FetchType.EAGER,
//            cascade= CascadeType.ALL
//    )
//    @JoinTable(
//            name = "user_role",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<Role> roles = new HashSet<>();

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private Set<Order> orders = new HashSet<>();

    public User(
            String name,
            String surname,
            String email,
            String password,
            String phoneNumber,
            String address,
            String country,
            String city,
            String postcode,
            Role role
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
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        GrantedAuthority authority = new SimpleGrantedAuthority(role.name());

        return List.of(authority);
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
