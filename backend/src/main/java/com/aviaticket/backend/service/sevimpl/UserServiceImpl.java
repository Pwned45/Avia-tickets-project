package com.aviaticket.backend.service.sevimpl;

import com.aviaticket.backend.exeption.EntityNotFoundException;
import com.aviaticket.backend.models.User;
import com.aviaticket.backend.repos.UserRepository;
import com.aviaticket.backend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) throws EntityNotFoundException {
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public User findByUserName(String name) {
        return userRepository.getByLogin(name);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
