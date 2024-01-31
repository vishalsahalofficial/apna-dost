package com.apnadost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ApnaDostApplication {
    private boolean is_authorization_enabled = false;

    public static void main(String[] args) {
        SpringApplication.run(ApnaDostApplication.class, args);
        System.out.println("HI");
    }
}

