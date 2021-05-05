package com.aviaticket.backend.exeption;

import lombok.Data;

@Data
public class EntityNotFoundException extends Exception{
    private int id;
    private String title;
    private String clazzName;
    public EntityNotFoundException(Long id, String clazzName) {
        super(String.format("'%s' is not found with id : '%s'", clazzName, id));
    }
    public EntityNotFoundException(String title, String clazzName) {
        super(String.format("'%s' is not found with title : '%s'", clazzName, title));
    }
    public EntityNotFoundException() {
        super("Something went wrong");
    }
}
