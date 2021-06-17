package com.aviaticket.backend.rest;

import com.aviaticket.backend.dto.CheckDto;
import com.aviaticket.backend.dto.UserDto;
import com.aviaticket.backend.exeption.EntityNotFoundException;
import com.aviaticket.backend.exeption.UserException;
import com.aviaticket.backend.service.UserService;
import com.aviaticket.backend.transfer.Details;
import com.aviaticket.backend.transfer.Existing;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRestController {
    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> allUsers() {
        List<UserDto> usersDtos = userService.listAll();
        if (usersDtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usersDtos, HttpStatus.OK);
    }

    @JsonView(Details.class)
    @PreAuthorize("hasAuthority('ADMIN')or hasAuthority('USER')")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> getClientByID(@PathVariable("id") Long id) throws EntityNotFoundException {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @GetMapping(value = "/{id}/checks", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CheckDto>> addClientComp(@PathVariable("id") Long id) throws EntityNotFoundException {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(userService.getHistory(id),HttpStatus.CREATED);
        }
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    @PatchMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> patchUser(@Validated(Existing.class) @PathVariable("id") Long id, @RequestBody UserDto userDto) throws DataIntegrityViolationException, EntityNotFoundException, UserException {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (userDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        userService.update(userDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
