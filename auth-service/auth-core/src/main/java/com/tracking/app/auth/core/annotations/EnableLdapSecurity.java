package com.tracking.app.auth.core.annotations;

import com.tracking.app.auth.core.config.LdapSecurityConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to enable LDAP-based authentication security.
 *
 * <p>When you put {@code @EnableLdapSecurity} on a class, it imports
 * {@link LdapSecurityConfig} and activates LDAP authentication for your app.</p>
 *
 * <p>Usage on the main application class:
 * <pre>
 * &#64;SpringBootApplication
 * &#64;EnableLdapSecurity
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
 * &#64;EnableLdapSecurity
 * public class SecurityBootstrapConfig {}
 * </pre>
 * </p>
 *
 * Author: Dharaneshwar
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(LdapSecurityConfig.class)
public @interface EnableLdapSecurity {}
