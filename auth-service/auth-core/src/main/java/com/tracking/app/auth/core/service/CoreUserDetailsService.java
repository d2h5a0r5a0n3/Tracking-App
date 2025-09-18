package com.tracking.app.auth.core.service;

import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * CoreUserDetailsService
 *
 * <p>A generic contract for fetching user details that can be implemented
 * by individual microservices. This interface is designed to decouple
 * the core authentication logic from service-specific user data sources.</p>
 *
 * <p>Typical implementations might query a database, call another service,
 * or fetch user data from an external identity provider. The returned
 * {@link UserDetails} object is then used by Spring Security for
 * authentication and authorization.</p>
 *
 * <p>Usage:
 * <ul>
 *   <li>Each microservice implements this interface to define how
 *       its user information is retrieved.</li>
 *   <li>Auth-core will delegate to the provided implementation when
 *       validating credentials or issuing tokens.</li>
 * </ul>
 * </p>
 *
 * @author Dharaneshwar
 * @since 1.0
 */
public interface CoreUserDetailsService {

    /**
     * Loads the user-specific data by username.
     *
     * <p>Implementations should look up the user based on the provided
     * username and return a fully populated {@link UserDetails} instance.
     * If the user is not found or an error occurs, an appropriate
     * exception should be thrown.</p>
     *
     * @param username the username identifying the user whose data is required
     * @return the {@link UserDetails} for the given username
     * @throws Exception if the user cannot be found or loaded
     */
    @SneakyThrows
    UserDetails loadUserByUsername(String username);
}
