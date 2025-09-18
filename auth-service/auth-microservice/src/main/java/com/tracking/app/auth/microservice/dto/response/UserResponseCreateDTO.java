package com.tracking.app.auth.microservice.dto.response;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * DTO for user creation responses.
 *
 * <p>Extends {@link UserResponseCRUD} to include creation-specific
 * details such as whether the user was successfully created
 * and the timestamp of creation.</p>
 *
 * Author: Dharaneshwar
 */
@Data
public class UserResponseCreateDTO extends UserResponseCRUD {

    /** Indicates whether the user was successfully created. */
    private boolean isCreated;

    /** Timestamp when the user was created. */
    private LocalDateTime createdAt;
}
