package com.aviaticket.backend.service;

import com.aviaticket.backend.dto.UserDto;
import com.aviaticket.backend.exeption.EntityNotFoundException;
import com.aviaticket.backend.models.User;

import java.util.List;

public interface UserService {
    List<UserDto> listAll();

    UserDto getById(Long id) throws EntityNotFoundException;

    User findByUserName(String name);

    void save(UserDto user);

    void deleteById(Long id);
}
