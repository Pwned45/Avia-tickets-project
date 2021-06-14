package com.aviaticket.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class Aplication {
    public static void main(String[] args) {
        SpringApplication.run(Aplication.class, args);
    }

}
