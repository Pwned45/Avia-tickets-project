package com.aviaticket.backend.service.sevimpl;

import com.aviaticket.backend.convector.UserMapper;
import com.aviaticket.backend.dto.UserDto;
import com.aviaticket.backend.exeption.EntityNotFoundException;
import com.aviaticket.backend.models.User;
import com.aviaticket.backend.repos.UserRepository;
import com.aviaticket.backend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDto> listAll() {
        return userMapper.toUserDTOs(userRepository.findAll());
    }

    @Override
    public UserDto getById(Long id) throws EntityNotFoundException {
        return userMapper.toUserDTO(userRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public User findByUserName(String name) {
        return userRepository.getByLogin(name);
    }

    @Override
    public void save(UserDto user) {
        userRepository.save(userMapper.toUser(user));
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
