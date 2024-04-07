package org.gr40in.secur.service;

import lombok.RequiredArgsConstructor;
import org.gr40in.secur.dao.User;
import org.gr40in.secur.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public User getUserByName(String name) {
        return userRepository.getUserByName(name).orElse(null);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.getUserByName(username)
                .map(user -> new org.springframework.security.core.userdetails.User(
                        user.getName(),
                        user.getPassword(),
                        Collections.singleton(user.getRole())

                ))
                .orElseThrow(() -> new UsernameNotFoundException("Not found user " + username));
    }

}
