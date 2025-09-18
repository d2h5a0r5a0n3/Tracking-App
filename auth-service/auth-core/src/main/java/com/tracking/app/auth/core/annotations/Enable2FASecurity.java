package com.tracking.app.auth.core.annotations;

import com.tracking.app.auth.core.config.Otp2FASecurityConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to enable OTP-based 2FA (two-factor authentication) security.
 *
 * <p>When you put {@code @Enable2FASecurity} on a class, it imports
 * {@link Otp2FASecurityConfig} and activates username + OTP authentication.</p>
 *
 * <p>Usage on the main application class:
 * <pre>
 * &#64;SpringBootApplication
 * &#64;Enable2FASecurity
 * public class UserServiceApplication {
 *     public static void main(String[] args) {
 *         SpringApplication.run(UserServiceApplication.class, args);
 *     }
 * }
 * </pre>
 *
 * Usage on a separate configuration class:
 * <pre>
 * &#64;Configuration
 * &#64;Enable2FASecurity
 * public class SecurityBootstrapConfig {}
 * </pre>
 * </p>
 *
 * Author: Dharaneshwar
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(Otp2FASecurityConfig.class)
public @interface Enable2FASecurity {}
