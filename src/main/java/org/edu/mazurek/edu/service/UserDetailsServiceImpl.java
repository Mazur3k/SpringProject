package org.edu.mazurek.edu.service;

import org.edu.mazurek.edu.configuration.UserDetailsImplementation;
import org.edu.mazurek.edu.model.User;
import org.edu.mazurek.edu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmailContainingIgnoreCase(username);
        return new UserDetailsImplementation(user.getRole().getName(), user.getPassword(), user.getEmail());
    }
}
