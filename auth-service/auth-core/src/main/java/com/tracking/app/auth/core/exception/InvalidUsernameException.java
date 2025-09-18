package com.tracking.app.auth.core.exception;

/**
 * InvalidUsernameException
 *
 * <p>Thrown to indicate that a provided username is invalid
 * during authentication or user lookup operations. This exception
 * is typically raised when a username does not meet expected
 * validation criteria or cannot be found in the data source.</p>
 *
 * <p>Usage:
 * <ul>
 *   <li>Thrown by authentication services when an invalid or
 *       non-existent username is supplied.</li>
 *   <li>Can be caught and translated into a standardized error
 *       response for API clients.</li>
 * </ul>
 * </p>
 *
 * @author Dharaneshwar
 * @since 1.0
 */
public class InvalidUsernameException extends RuntimeException {

    /**
     * Constructs a new {@code InvalidUsernameException} with the specified detail message.
     *
     * @param message the detail message providing more context about the error
     */
    public InvalidUsernameException(String message) {
        super(message);
    }
}
