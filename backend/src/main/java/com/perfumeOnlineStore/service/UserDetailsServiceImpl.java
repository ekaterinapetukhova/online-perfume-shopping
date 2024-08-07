package com.perfumeOnlineStore.service;

import com.perfumeOnlineStore.entity.User;
import com.perfumeOnlineStore.repository.UserRepository;
import com.perfumeOnlineStore.tools.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.getUserByEmail(email);

        if (user == null) throw new UsernameNotFoundException("Could not find user");

        return new UserDetailsImpl(user);
    }
}
