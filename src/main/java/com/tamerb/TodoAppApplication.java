package com.tamerb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class TodoAppApplication {

    // Main
    public static void main(String[] args) {

        SpringApplication.run(TodoAppApplication.class, args);
    }

}
