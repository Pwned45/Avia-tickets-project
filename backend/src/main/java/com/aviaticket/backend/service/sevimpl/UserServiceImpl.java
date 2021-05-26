package com.aviaticket.backend.service.sevimpl;

import com.aviaticket.backend.convector.ChecksMapper;
import com.aviaticket.backend.convector.UserMapper;
import com.aviaticket.backend.dto.CheckDto;
import com.aviaticket.backend.dto.UserDto;
import com.aviaticket.backend.exeption.EntityNotFoundException;
import com.aviaticket.backend.exeption.UserException;
import com.aviaticket.backend.models.Roles;
import com.aviaticket.backend.models.User;
import com.aviaticket.backend.repos.LocationRepository;
import com.aviaticket.backend.repos.UserRepository;
import com.aviaticket.backend.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final ChecksMapper checksMapper;
    private final BCryptPasswordEncoder passwordEncoder;
    private final LocationRepository locationRepository;


    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, ChecksMapper checksMapper, BCryptPasswordEncoder passwordEncoder, LocationRepository locationRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.checksMapper = checksMapper;
        this.passwordEncoder = passwordEncoder;
        this.locationRepository = locationRepository;
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
    public List<CheckDto> getHistory(Long id) throws EntityNotFoundException {
        User user = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return checksMapper.toCheckDTOs(user.getChecks());
    }

    @Override
    public void update(UserDto userDto) throws EntityNotFoundException, UserException {
        User newUser = userRepository.findById(userDto.getIdUser()).orElseThrow(EntityNotFoundException::new);
        if (!userDto.getEmail().equals(newUser.getEmail())) {
            if (userRepository.existsByEmaleIs(userDto.getEmail()) > 0) {
                throw new UserException("emale");
            } else {
                newUser.setEmail(userDto.getEmail());
            }
        }
        newUser.setLocation(locationRepository.findById(userDto.getLocationDto().getIdLocation()).orElseThrow(EntityNotFoundException::new));
        newUser.setName(userDto.getName());
        newUser.setLastName(userDto.getLastName());
        if (userDto.getPass() != null) {
            newUser.setPass(passwordEncoder.encode(userDto.getPass()));
        }
        newUser.setBornDay(userDto.getBornDay());
        newUser.setPhone(userDto.getPhone());
        userRepository.save(newUser);
    }

    @Override
    public void register(UserDto userDto) throws UserException, EntityNotFoundException {
        if (userRepository.existsByLoginIs(userDto.getLogin()) > 0) {
            throw new UserException("login");
        }
        if (userRepository.existsByEmaleIs(userDto.getEmail()) > 0) {
            throw new UserException("email");
        }
        User user = new User();
        user.setName(userDto.getName());
        user.setLocation(locationRepository.findById(userDto.getLocationDto().getIdLocation()).orElseThrow(EntityNotFoundException::new));
        user.setLastName(userDto.getLastName());
        user.setBornDay(userDto.getBornDay());
        user.setPhone(userDto.getPhone());
        user.setLogin(userDto.getLogin());
        user.setEmail(userDto.getEmail());
        user.setPass(passwordEncoder.encode(userDto.getPass()));
        user.setRoles(Roles.USER);
        userRepository.save(user);

    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
