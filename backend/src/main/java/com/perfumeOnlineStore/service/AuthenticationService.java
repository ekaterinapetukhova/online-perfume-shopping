package com.perfumeOnlineStore.service;

import com.perfumeOnlineStore.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final JwtService jwtService;

    public String registerUser(User user) {
        userService.saveUser(user);

        return jwtService.generateToken(user);
    }
}
