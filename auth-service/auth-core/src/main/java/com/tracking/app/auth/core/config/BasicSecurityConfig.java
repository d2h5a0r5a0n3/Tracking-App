package com.tracking.app.auth.core.config;

import com.tracking.app.auth.core.common.AuthEntryPoint;
import com.tracking.app.auth.core.common.CorsConfig;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Basic username/password authentication configuration.
 *
 * <p>Provides security setup for:
 * <ul>
 *   <li>Public endpoints: accessible without login</li>
 *   <li>Secured endpoints: require login with username/password</li>
 * </ul>
 *
 * <p>Uses {@link AuthEntryPoint} for handling unauthorized access
 * and {@link CorsConfig} for cross-origin requests.</p>
 *
 * Author: Dharaneshwar
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class BasicSecurityConfig {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final AuthEntryPoint authEntryPoint;
    private final CorsConfig corsConfig;

    /**
     * Provides the authentication manager used by Spring Security.
     *
     * @param configuration the authentication configuration
     * @return authentication manager for username/password login
     */
    @Bean
    @SneakyThrows
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) {
        return configuration.getAuthenticationManager();
    }

    /**
     * Security rules for public endpoints.
     *
     * <p>All endpoints under "/api/public/**" are accessible without login.
     *
     * @param http the HTTP security object
     * @return configured security filter chain for public endpoints
     */
    @Bean
    @SneakyThrows
    public SecurityFilterChain publicEndpoints(HttpSecurity http) {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .securityMatcher("/api/public/**")
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
                .httpBasic(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable);
        return http.build();
    }

    /**
     * Security rules for all secured endpoints.
     *
     * <p>Requires authentication for all requests except public endpoints.
     *
     * @param http the HTTP security object
     * @return configured security filter chain for secured endpoints
     */
    @Bean
    @SneakyThrows
    public SecurityFilterChain securedEndpoints(HttpSecurity http) {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .httpBasic(httpBasic -> httpBasic.authenticationEntryPoint(authEntryPoint))
                .formLogin(AbstractHttpConfigurer::disable)
                .logout(Customizer.withDefaults());
        return http.build();
    }
}
