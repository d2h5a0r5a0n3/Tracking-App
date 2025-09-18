package com.tracking.app.auth.microservice.service;

import com.tracking.app.auth.core.service.CoreUserDetailsService;
import com.tracking.app.auth.microservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link CoreUserDetailsService} for loading user details.
 *
 * <p>This service is used by Spring Security during authentication to
 * fetch user credentials and account status from the database.</p>
 *
 * <p>It converts your application's {@code User} entity into a
 * {@link org.springframework.security.core.userdetails.UserDetails} object,
 * which Spring Security can understand for authentication and authorization.</p>
 *
 * Author: Dharaneshwar
 */
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImp implements CoreUserDetailsService {

    private final UserRepository userRepository;

    /**
     * Loads a user by username.
     *
     * @param username the username of the user
     * @return {@link UserDetails} containing username, password, and account status
     * @throws UsernameNotFoundException if the user is not found in the database
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(user -> User.withUsername(user.getUsername())
                        .password(user.getPassword())
                        .disabled(!user.isActive())
                        .accountLocked(user.isLocked())
                        .build()
                ).orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }
}
