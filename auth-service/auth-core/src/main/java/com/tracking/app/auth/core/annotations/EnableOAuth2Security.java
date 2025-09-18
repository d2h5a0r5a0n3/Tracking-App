package com.tracking.app.auth.core.annotations;

import com.tracking.app.auth.core.config.OAuth2SecurityConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to enable OAuth2 authentication security.
 *
 * <p>When you put {@code @EnableOAuth2Security} on a class, it imports
 * {@link OAuth2SecurityConfig} and sets up OAuth2 login/authorization for your app.</p>
 *
 * <p>Usage on the main application class:
 * <pre>
 * &#64;SpringBootApplication
 * &#64;EnableOAuth2Security
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
 * &#64;EnableOAuth2Security
 * public class SecurityBootstrapConfig {}
 * </pre>
 * </p>
 *
 * Author: Dharaneshwar
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(OAuth2SecurityConfig.class)
public @interface EnableOAuth2Security {}
