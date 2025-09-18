package com.tracking.app.auth.core.annotations;

import com.tracking.app.auth.core.config.BasicSecurityConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to enable basic authentication security.
 *
 * <p>When you put {@code @EnableBasicSecurity} on a class,
 * it will import {@link BasicSecurityConfig} and configure
 * username/password-based authentication (standard login flow).</p>
 *
 * <p>Usage on main application class:
 * <pre>
 * &#64;SpringBootApplication
 * &#64;EnableBasicSecurity
 * public class AuthServiceApplication {
 *     public static void main(String[] args) {
 *         SpringApplication.run(AuthServiceApplication.class, args);
 *     }
 * }
 * </pre>
 *
 * Usage on a separate configuration class:
 * <pre>
 * &#64;Configuration
 * &#64;EnableBasicSecurity
 * public class SecurityBootstrapConfig {}
 * </pre>
 * </p>
 *
 * Author: Dharaneshwar
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(BasicSecurityConfig.class)
public @interface EnableBasicSecurity {}
