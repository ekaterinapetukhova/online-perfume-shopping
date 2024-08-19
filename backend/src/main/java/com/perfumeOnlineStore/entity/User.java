package com.perfumeOnlineStore.entity;

import com.fasterxml.jackson.annotation.*;
import com.perfumeOnlineStore.utils.encryption.aes.StringAesEncrypt;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = { "hibernateLazyInitializer" })
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Convert(converter = StringAesEncrypt.class)
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    @Convert(converter = StringAesEncrypt.class)
    private String surname;
    @Column(unique = true, nullable = false)
    @Convert(converter = StringAesEncrypt.class)
    private String email;
    @Column(nullable = false)
    private String password;
    @Convert(converter = StringAesEncrypt.class)
    private String phoneNumber;
    @Convert(converter = StringAesEncrypt.class)
    private String address;
    @Convert(converter = StringAesEncrypt.class)
    private String country;
    @Convert(converter = StringAesEncrypt.class)
    private String city;
    @Convert(converter = StringAesEncrypt.class)
    private String postcode;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private Set<Order> orders = new HashSet<>();

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Session> sessions = new HashSet<>();

    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = { CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH }
    )
    @JoinTable(
            name = "user_role",
            joinColumns = { @JoinColumn(name="user_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name="role_id", referencedColumnName = "id") }
    )
    private Set<Role> roles = new HashSet<>();

    public User(
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Role role : roles) authorities.add(new SimpleGrantedAuthority(role.getName()));

        return authorities;
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
