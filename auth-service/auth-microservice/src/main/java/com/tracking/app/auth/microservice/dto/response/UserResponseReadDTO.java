package com.tracking.app.auth.microservice.dto.response;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * DTO for user login (read) responses.
 *
 * <p>Extends {@link UserResponseCRUD} to include login-specific
 * details such as whether the user successfully logged in
 * and the timestamp of the login.</p>
 *
 * Author: Dharaneshwar
 */
@Data
public class UserResponseReadDTO extends UserResponseCRUD {

    /** Indicates whether the user successfully logged in. */
    private boolean isLoggedIn;

    /** Timestamp when the user logged in. */
    private LocalDateTime loggedInAt;
}
