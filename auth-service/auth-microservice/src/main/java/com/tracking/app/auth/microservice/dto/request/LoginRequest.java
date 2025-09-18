package com.tracking.app.auth.microservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * DTO for user login requests.
 *
 * <p>Contains the username and password provided by the client
 * when attempting to log in.</p>
 *
 * <p>Validation annotations ensure that both fields are provided.</p>
 *
 * Author: Dharaneshwar
 */
@Data
public class LoginRequest {

    /** Username of the user trying to log in. Cannot be blank. */
    @NotBlank(message = "Username is required")
    private String username;

    /** Password of the user. Cannot be blank. */
    @NotBlank(message = "Password is required")
    private String password;
}
