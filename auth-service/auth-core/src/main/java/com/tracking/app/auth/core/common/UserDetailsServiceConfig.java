package com.tracking.app.auth.core.common;

import com.tracking.app.auth.core.service.CoreUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Maps our custom {@link CoreUserDetailsService} to Spring Security's
 * {@link UserDetailsService}.
 *
 * <p>Why? Spring Security expects a {@code UserDetailsService} bean.
 * Instead of making every service implement it directly, we use our
 * own {@code CoreUserDetailsService} and wrap it here. This keeps our
 * auth-core module reusable across microservices.</p>
 *
 * <p>Example:
 * <ul>
 *   <li>Your service implements {@code CoreUserDetailsService} to fetch users.</li>
 *   <li>Spring will automatically use this config to plug it into the
 *       security framework.</li>
 * </ul>
 * </p>
 *
 * Author: Dharaneshwar
 */
@Configuration
public class UserDetailsServiceConfig {

    /**
     * Delegates user lookup to {@link CoreUserDetailsService}.
     *
     * @param delegate your service’s implementation of {@code CoreUserDetailsService}
     * @return a Spring Security-compatible {@code UserDetailsService}
     */
    @Bean
    public UserDetailsService userDetailsService(CoreUserDetailsService delegate) {
        return username -> delegate.loadUserByUsername(username);
    }
}
