package com.aviaticket.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Aplication {
    public static void main(String[] args) {
        SpringApplication.run(Aplication.class, args);
    }

}
