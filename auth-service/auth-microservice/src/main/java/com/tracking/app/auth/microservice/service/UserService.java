package com.tracking.app.auth.microservice.service;

import com.tracking.app.auth.core.exception.InvalidPasswordException;
import com.tracking.app.auth.core.exception.InvalidUsernameException;
import com.tracking.app.auth.microservice.dto.response.*;
import com.tracking.app.auth.microservice.model.User;
import com.tracking.app.auth.microservice.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Service class for handling user operations in the Auth Microservice.
 *
 * <p>Provides registration, login, update, and deletion functionality
 * with proper exception handling and password encryption.</p>
 *
 * Author: Dharaneshwar
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    /**
     * Registers a new user with encoded password and default settings.
     *
     * @param user the user entity to register
     * @return response DTO containing creation status and details
     */
    @Transactional
    public UserResponseCreateDTO registerUser(User user) {
        UserResponseCreateDTO response = new UserResponseCreateDTO();

        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            response.setMessage("Username already exists");
            response.setCreated(false);
            response.setUsername(user.getUsername());
            return response;
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        user.setLocked(false);
        var savedUser = userRepository.save(user);

        response.setMessage("User created successfully");
        response.setCreated(true);
        response.setUsername(savedUser.getUsername());
        response.setUserId(savedUser.getId());
        response.setCreatedAt(LocalDateTime.now());

        return response;
    }

    /**
     * Deletes a user by their ID.
     *
     * @param userId the ID of the user to delete
     * @return response DTO containing deletion status and details
     */
    @Transactional
    public UserResponseDeleteDTO deleteUser(Long userId) {
        UserResponseDeleteDTO response = new UserResponseDeleteDTO();
        userRepository.deleteById(userId);

        response.setMessage("User deleted successfully");
        response.setDeleted(true);
        response.setUserId(userId);
        response.setDeletedAt(LocalDateTime.now());

        return response;
    }

    /**
     * Authenticates a user with username and password.
     *
     * @param username the username
     * @param password the password
     * @return response DTO containing login status and details
     * @throws InvalidUsernameException if the username is invalid
     * @throws InvalidPasswordException if the password is invalid
     */
    public UserResponseReadDTO loginUser(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidUsernameException("Username and password cannot be null");
        }

        UserResponseReadDTO response = new UserResponseReadDTO();

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            if (authentication.isAuthenticated()) {
                Optional<User> optionalUser = userRepository.findByUsername(username);
                if (optionalUser.isPresent()) {
                    User user = optionalUser.get();
                    user.setLastLoginAt(LocalDateTime.now());
                    userRepository.save(user);

                    response.setUsername(username);
                    response.setLoggedIn(true);
                    response.setMessage("Logged in successfully");
                    response.setLoggedInAt(LocalDateTime.now());
                    response.setUserId(user.getId());
                }
            }
        } catch (UsernameNotFoundException e) {
            throw new InvalidUsernameException("Invalid username: " + username);
        } catch (BadCredentialsException e) {
            throw new InvalidPasswordException("Invalid password for username: " + username);
        } catch (Exception e) {
            throw new AuthenticationServiceException("Authentication failed", e);
        }

        return response;
    }

    /**
     * Updates an existing user's details.
     *
     * @param user the user entity with updated information
     * @return response DTO containing update status and details
     */
    public UserResponseUpdateDTO updateUser(User user) {
        UserResponseUpdateDTO response = new UserResponseUpdateDTO();
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());

        if (existingUser.isPresent()) {
            User updatedUser = existingUser.get();
            updatedUser.setFirstname(user.getFirstname());
            updatedUser.setLastname(user.getLastname());
            updatedUser.setGender(user.getGender());
            updatedUser.setDateOfBirth(user.getDateOfBirth());
            updatedUser.setCountryCode(user.getCountryCode());
            updatedUser.setLocked(user.isLocked());
            updatedUser.setActive(user.isActive());
            updatedUser.setAddress(user.getAddress());
            updatedUser.setMail(user.getMail());
            updatedUser.setPhoneNumber(user.getPhoneNumber());
            updatedUser.setLastLoginAt(LocalDateTime.now());

            User savedUser = userRepository.save(updatedUser);

            response.setMessage("User updated successfully");
            response.setUsername(savedUser.getUsername());
            response.setUserId(savedUser.getId());
            response.setUpdatedAt(LocalDateTime.now());
            response.setUpdated(true);
        } else {
            response.setMessage("User not found");
            response.setUpdated(false);
            response.setUserId(user.getId());
            response.setUpdatedAt(LocalDateTime.now());
            response.setUsername(user.getUsername());
        }

        return response;
    }
}
