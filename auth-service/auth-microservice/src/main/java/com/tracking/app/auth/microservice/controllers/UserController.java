package com.tracking.app.auth.microservice.controllers;

import com.tracking.app.auth.microservice.dto.request.LoginRequest;
import com.tracking.app.auth.microservice.dto.response.UserResponseCreateDTO;
import com.tracking.app.auth.microservice.dto.response.UserResponseDeleteDTO;
import com.tracking.app.auth.microservice.dto.response.UserResponseReadDTO;
import com.tracking.app.auth.microservice.dto.response.UserResponseUpdateDTO;
import com.tracking.app.auth.microservice.model.User;
import com.tracking.app.auth.microservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller to handle user-related operations in the Auth Microservice.
 *
 * <p>Endpoints include:
 * <ul>
 *   <li>Registering a new user</li>
 *   <li>Logging in an existing user</li>
 *   <li>Deleting a user account</li>
 *   <li>Updating user details</li>
 * </ul>
 *
 * <p>Endpoints are split between public (no authentication required)
 * and private (authentication required) paths.</p>
 *
 * Author: Dharaneshwar
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    /**
     * Registers a new user account.
     *
     * <p>Public endpoint, accessible without authentication.</p>
     *
     * @param user the user object containing registration details
     * @return response DTO containing creation status and metadata
     */
    @PostMapping("/public/auth-service/user/create-account")
    public ResponseEntity<UserResponseCreateDTO> createUser(@RequestBody User user) {
        log.info("Registering the user");
        UserResponseCreateDTO response = userService.registerUser(user);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Logs in an existing user using username and password.
     *
     * <p>Public endpoint, accessible without authentication.</p>
     *
     * @param request DTO containing username and password
     * @return response DTO containing login status and metadata
     */
    @PostMapping("/public/auth-service/user/login")
    public ResponseEntity<UserResponseReadDTO> loginUser(@RequestBody LoginRequest request) {
        UserResponseReadDTO response = userService.loginUser(request.getUsername(), request.getPassword());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Deletes an existing user account.
     *
     * <p>Private endpoint, authentication required.</p>
     *
     * @param userId ID of the user to delete
     * @return response DTO containing deletion status and metadata
     */
    @DeleteMapping("/private/auth-service/user/delete-account")
    public ResponseEntity<UserResponseDeleteDTO> deleteUser(@RequestParam Long userId) {
        UserResponseDeleteDTO response = userService.deleteUser(userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Updates an existing user account with new information.
     *
     * <p>Private endpoint, authentication required.</p>
     *
     * @param user the user object containing updated information
     * @return response DTO containing update status and metadata
     */
    @PutMapping("/private/auth-service/user/update-account")
    public ResponseEntity<UserResponseUpdateDTO> updateUser(@RequestBody User user) {
        UserResponseUpdateDTO response = userService.updateUser(user);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
