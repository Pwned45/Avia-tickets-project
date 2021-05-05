package com.aviaticket.backend.security;

import com.aviaticket.backend.models.User;
import com.aviaticket.backend.security.jwt.JwtUser;
import com.aviaticket.backend.security.jwt.JwtUserFactory;
import com.aviaticket.backend.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class JwtUserDetailsService implements UserDetailsService {
    private final UserService userService;
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtUserDetailsService.class);
    @Autowired
    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUserName(username);

        if (user == null) {
            throw new UsernameNotFoundException("User with username: " + username + " not found");
        }
        JwtUser jwtUser = JwtUserFactory.create(user);
        LOGGER.info("JwtUser created");
        return jwtUser;
    }
}
