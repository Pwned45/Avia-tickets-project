package com.aviaticket.backend.rest;

import com.aviaticket.backend.dto.AuthenticationRequestDto;
import com.aviaticket.backend.dto.UserDto;
import com.aviaticket.backend.exeption.EntityNotFoundException;
import com.aviaticket.backend.exeption.UserException;
import com.aviaticket.backend.models.User;
import com.aviaticket.backend.security.jwt.JwtTokenProvider;
import com.aviaticket.backend.service.UserService;
import com.aviaticket.backend.transfer.New;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthRestController {
    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;

    public AuthRestController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @PostMapping("login")
    public ResponseEntity login(@RequestBody AuthenticationRequestDto requestDto) {
        try {
            String login = requestDto.getLogin();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, requestDto.getPass()));
            User user = userService.findByUserName(login);

            if (user == null) {
                throw new UsernameNotFoundException("User with username: " + login + " not found");
            }

            String token = jwtTokenProvider.createToken(login, user.getRoles());
// я сказал стартуем хер нахер
            Map<Object, Object> response = new HashMap<>();
            response.put("id", user.getIdUser());
            response.put("role", user.getRoles());
            response.put("login", login);
            response.put("token", token);
            response.put("name", user.getName());
            response.put("Lname", user.getLastName());
            response.put("born", user.getBornDay());
            response.put("emale", user.getEmail());
            response.put("phone", user.getPhone());
            response.put("location_id", user.getLocation().getIdLocation());
            response.put("location_city", user.getLocation().getCity());

            return ResponseEntity.ok(response);

        } catch (AuthenticationException e) {
            System.out.println(e.toString());
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @PostMapping(value = "/reg", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
        MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registration(@Validated(New.class) @RequestBody UserDto userDto) throws EntityNotFoundException, UserException {
        if (userDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            userService.register(userDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
}
