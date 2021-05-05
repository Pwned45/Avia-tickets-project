package com.aviaticket.backend.service;

import com.aviaticket.backend.exeption.EntityNotFoundException;
import com.aviaticket.backend.models.User;

import java.util.List;

public interface UserService {
    List<User> listAll();

    User getById(Long id) throws EntityNotFoundException;

    User findByUserName(String name);

    void save(User user);

    void deleteById(Long id);
}
