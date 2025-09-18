package com.tracking.app.auth.microservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Controller to check the authentication status of a user.
 *
 * <p>Private endpoint that returns the current authentication
 * information for the logged-in user.</p>
 *
 * Example usage:
 * <pre>
 * GET /api/private/auth-service/status
 * Response: {
 *     "authenticated": true,
 *     "username": "john_doe"
 * }
 * </pre>
 *
 * Author: Dharaneshwar
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/private/auth-service")
public class AuthController {

    /**
     * Returns the authentication status of the current user.
     *
     * @param authentication the Spring Security Authentication object injected automatically
     * @return a map containing authentication status and username if authenticated
     */
    @GetMapping("/status")
    public ResponseEntity<Map<Object, Object>> status(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return ResponseEntity.ok(Map.of(
                    "authenticated", true,
                    "username", authentication.getName()
            ));
        }
        return ResponseEntity.ok(Map.of("authenticated", false));
    }
}
