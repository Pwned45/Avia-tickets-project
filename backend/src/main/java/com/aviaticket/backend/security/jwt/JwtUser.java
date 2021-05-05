package com.aviaticket.backend.security.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class JwtUser implements UserDetails {

    private final Long idUser;
    private final Collection<? extends GrantedAuthority> authorities;
    private final String firstName;
    private final String lastName;
    private final String login;
    private final String pass;
    private final String emale;
    private final Long telephone;

    public JwtUser(Long idUser, Collection<? extends GrantedAuthority> authorities, String firstName, String lastName, String login, String pass, String emale, Long telephone) {
        this.idUser = idUser;
        this.authorities = authorities;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.pass = pass;
        this.emale = emale;
        this.telephone = telephone;
    }


    @JsonIgnore
    public Long getId() {
        return idUser;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public String getFirstname() {
        return firstName;
    }

    public String getLastname() {
        return lastName;
    }

    public String getEmail() {
        return emale;
    }

    public Long getTelephone() {
        return telephone;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return pass;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
