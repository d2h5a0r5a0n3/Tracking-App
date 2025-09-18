package com.tracking.app.auth.core.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Provides a {@link PasswordEncoder} bean for the app.
 *
 * <p>We use {@link BCryptPasswordEncoder} because it is secure and
 * automatically handles salting + hashing. This ensures we never
 * store or compare raw passwords.</p>
 *
 * <p>Spring Security will automatically use this bean for
 * password encoding and validation (e.g., during login).</p>
 *
 * Author: Dharaneshwar
 */
@Configuration
public class PasswordEncoderConfig {

    /**
     * Returns a BCrypt-based password encoder.
     *
     * @return password encoder for hashing and verifying passwords
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
