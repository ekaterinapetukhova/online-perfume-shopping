package com.perfumeOnlineStore.service;

import com.perfumeOnlineStore.entity.Role;
import com.perfumeOnlineStore.entity.User;
import com.perfumeOnlineStore.repository.RoleRepository;
import com.perfumeOnlineStore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(UUID id) {
        return userRepository.findById(id);
    }

    public User findUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    public void saveUser(User user) {
        Role userRole = roleRepository.findByName("USER");
        user.setRoles(Set.of(userRole));
        userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
