package com.tracking.app.auth.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for the Auth Microservice application.
 *
 * <p>This is the entry point of the authentication microservice.
 * It bootstraps the Spring Boot application and enables all
 * configured security modules and beans from the auth-core module.</p>
 *
 * <p>Usage: Run this class to start the Auth Microservice.</p>
 *
 * Author: Dharaneshwar
 */
@SpringBootApplication
public class AuthMicroServiceApplication {

    /**
     * Main method to start the Spring Boot application.
     *
     * @param args application arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(AuthMicroServiceApplication.class, args);
    }
}
