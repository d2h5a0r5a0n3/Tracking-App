package com.tracking.app.auth.microservice.configuration;

import com.tracking.app.auth.core.annotations.EnableBasicSecurity;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class to enable basic authentication security
 * in the Auth Microservice.
 *
 * <p>By adding {@code @EnableBasicSecurity}, this class imports
 * the {@link com.tracking.app.auth.core.config.BasicSecurityConfig}
 * and activates basic security for the application.</p>
 *
 * Example usage:
 * <pre>
 * &#64;SpringBootApplication
 * &#64;EnableBasicSecurity
 * public class AuthMicroServiceApplication {
 *     public static void main(String[] args) {
 *         SpringApplication.run(AuthMicroServiceApplication.class, args);
 *     }
 * }
 * </pre>
 *
 * Author: Dharaneshwar
 */
@Configuration
@EnableBasicSecurity
public class SecurityEnablerConfig {
    // No additional code needed; annotation handles security configuration
}
