package com.tracking.app.auth.microservice.dto.response;

import lombok.Data;

/**
 * Base DTO for user CRUD operation responses.
 *
 * <p>This class contains common fields shared across all user
 * response DTOs for create, read, update, and delete operations.</p>
 *
 * Fields include:
 * <ul>
 *     <li>{@code message} - descriptive message about the operation</li>
 *     <li>{@code userId} - ID of the affected user</li>
 *     <li>{@code username} - username of the affected user</li>
 * </ul>
 *
 * Author: Dharaneshwar
 */
@Data
public abstract class UserResponseCRUD {

    /** Descriptive message about the operation (e.g., "User created successfully"). */
    private String message;

    /** ID of the user involved in the operation. */
    private Long userId;

    /** Username of the user involved in the operation. */
    private String username;
}
