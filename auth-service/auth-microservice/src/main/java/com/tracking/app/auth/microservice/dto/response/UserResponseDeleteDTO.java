package com.tracking.app.auth.microservice.dto.response;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * DTO for user deletion responses.
 *
 * <p>Extends {@link UserResponseCRUD} to include deletion-specific
 * details such as whether the user was successfully deleted
 * and the timestamp of deletion.</p>
 *
 * Author: Dharaneshwar
 */
@Data
public class UserResponseDeleteDTO extends UserResponseCRUD {

    /** Indicates whether the user was successfully deleted. */
    private boolean isDeleted;

    /** Timestamp when the user was deleted. */
    private LocalDateTime deletedAt;
}
