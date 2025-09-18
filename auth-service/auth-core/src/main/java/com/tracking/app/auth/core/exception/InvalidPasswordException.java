package com.tracking.app.auth.core.exception;

/**
 * InvalidPasswordException
 *
 * <p>Thrown to indicate that a provided password is invalid
 * during authentication or validation operations. This exception
 * is typically raised when the password does not match the stored
 * credentials, fails validation checks, or violates security policies.</p>
 *
 * <p>Usage:
 * <ul>
 *   <li>Thrown by authentication services when an incorrect password
 *       is supplied for a valid username.</li>
 *   <li>Can be caught and mapped to an appropriate error response
 *       for API clients.</li>
 * </ul>
 * </p>
 *
 * @author Dharaneshwar
 * @since 1.0
 */
public class InvalidPasswordException extends RuntimeException {

    /**
     * Constructs a new {@code InvalidPasswordException} with the specified detail message.
     *
     * @param message the detail message providing more context about the error
     */
    public InvalidPasswordException(String message) {
        super(message);
    }
}
