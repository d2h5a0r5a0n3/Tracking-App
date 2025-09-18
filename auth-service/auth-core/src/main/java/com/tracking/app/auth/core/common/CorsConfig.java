package com.tracking.app.auth.core.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

/**
 * Configures CORS (Cross-Origin Resource Sharing) for the app.
 *
 * <p>This allows our frontend (running on <b>http://localhost:4200</b>)
 * to call backend APIs without being blocked by the browser.</p>
 *
 * <p>We allow common HTTP methods, all headers, and credentials
 * (cookies/authorization headers).</p>
 *
 * Author: Dharaneshwar
 */
@Configuration
public class CorsConfig {

    /**
     * Defines the CORS rules for all endpoints (/**).
     *
     * @return a CORS configuration source with allowed origins, methods, and headers
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:4200");
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
