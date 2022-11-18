package com.example.libraryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class LibraryService {

    public static void main(String[] args) {
        SpringApplication.run(com.example.libraryservice.LibraryService.class, args);
    }

}
