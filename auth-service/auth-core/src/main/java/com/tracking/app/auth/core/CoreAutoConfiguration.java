package com.tracking.app.auth.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * CoreAutoConfiguration
 *
 * <p>This configuration class enables component scanning for the
 * {@code com.tracking.app.auth.core} package. It ensures that all
 * Spring-managed components (such as services, repositories, and
 * configuration classes) within the core authentication module
 * are automatically detected and registered in the application
 * context.</p>
 *
 * <p>Usage:
 * <ul>
 *   <li>Include this module as a dependency in other microservices
 *       to reuse the authentication core logic.</li>
 *   <li>Spring Boot will automatically pick up this configuration
 *       if it is available on the classpath.</li>
 * </ul>
 * </p>
 *
 * @author YourName
 * @since 1.0
 */
@Configuration
@ComponentScan(basePackages = "com.tracking.app.auth.core")
public class CoreAutoConfiguration {
}
