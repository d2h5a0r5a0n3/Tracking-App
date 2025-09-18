package com.tracking.app.auth.microservice.repository;

import com.tracking.app.auth.microservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for managing {@link User} entities.
 *
 * <p>Extends {@link JpaRepository} to provide standard CRUD operations
 * (create, read, update, delete) for the User entity.</p>
 *
 * <p>Custom method provided:
 * <ul>
 *   <li>{@link #findByUsername(String)} - Find a user by their username, returning
 *   an {@link Optional} to handle cases where the user may not exist.</li>
 * </ul>
 * </p>
 *
 * <p>This repository is used by services like {@code UserService} and
 * {@code UserDetailsServiceImp} to access user data from the database.</p>
 *
 * Author: Dharaneshwar
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Finds a user by username.
     *
     * @param username the username to search for
     * @return an {@link Optional} containing the user if found, or empty if not
     */
    Optional<User> findByUsername(String username);
}
