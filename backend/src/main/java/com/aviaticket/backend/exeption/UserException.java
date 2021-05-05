package com.aviaticket.backend.exeption;

import lombok.Data;

@Data
public class UserException extends Exception {
    String problem;

    public UserException(String problem) {
        super(String.format("This '%s' already exists", problem));
    }
}
