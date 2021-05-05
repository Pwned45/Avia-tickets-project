package com.aviaticket.backend.security.jwt;

import com.aviaticket.backend.models.Roles;
import com.aviaticket.backend.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    public JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
            user.getIdUser(),
            mapToGrantedAuthorities(user.getRoles()),
            user.getName(),
            user.getLastName(),
            user.getLogin(),
            user.getPass(),
            user.getEmail(),
            user.getPhone()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(Roles roles) {
        List<Roles> userRoles= new ArrayList<Roles>(){{add(roles);}};

        return userRoles.stream()
            .map(role ->
                new SimpleGrantedAuthority(role.name())
            ).collect(Collectors.toList());
    }
}
