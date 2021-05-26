package com.aviaticket.backend.service;

import com.aviaticket.backend.dto.CheckDto;
import com.aviaticket.backend.dto.UserDto;
import com.aviaticket.backend.exeption.EntityNotFoundException;
import com.aviaticket.backend.exeption.UserException;
import com.aviaticket.backend.models.User;

import java.util.List;

public interface UserService {
    List<UserDto> listAll();

    UserDto getById(Long id) throws EntityNotFoundException;

    User findByUserName(String name);

    void save(UserDto user);

    List<CheckDto> getHistory(Long id) throws EntityNotFoundException;

    void update(UserDto userDto) throws EntityNotFoundException, UserException;

    void register(UserDto clientsDto) throws UserException, EntityNotFoundException;

    void deleteById(Long id);
}
