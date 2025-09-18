package com.tracking.app.auth.microservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Controller to handle simple welcome endpoints for the auth service.
 *
 * <p>This endpoint is typically used to verify that the service is
 * up and running or for testing connectivity.</p>
 *
 * Example usage:
 * <pre>
 * GET /api/private/auth-service/welcome
 * Response: "Welcome"
 * </pre>
 *
 * Author: Dharaneshwar
 */
@RestController
@RequestMapping("/api/private/auth-service/welcome")
public class WelcomeController {

    /**
     * Returns a simple welcome message.
     *
     * @return a plain text "Welcome" string
     */
    @GetMapping
    public Map<String, String> welcome() {
        return Map.of("message", "Welcome");
    }
}
