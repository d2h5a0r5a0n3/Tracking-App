package com.tracking.app.auth.microservice.dto.response;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * DTO for user update responses.
 *
 * <p>Extends {@link UserResponseCRUD} to include update-specific
 * details such as whether the user was successfully updated
 * and the timestamp of the update.</p>
 *
 * Author: Dharaneshwar
 */
@Data
public class UserResponseUpdateDTO extends UserResponseCRUD {

    /** Indicates whether the user was successfully updated. */
    private boolean isUpdated;

    /** Timestamp when the user was updated. */
    private LocalDateTime updatedAt;
}
