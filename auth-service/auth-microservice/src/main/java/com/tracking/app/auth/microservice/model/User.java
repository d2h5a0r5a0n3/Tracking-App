package com.tracking.app.auth.microservice.model;

import com.tracking.app.auth.microservice.model.embeddable.Address;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Entity representing a User in the authentication microservice.
 *
 * <p>Contains personal information, login credentials, account status,
 * and embedded address details.</p>
 *
 * <p>Validation annotations ensure basic data integrity for fields such as
 * username, email, and password.</p>
 *
 * Author: Dharaneshwar
 */
@Entity
@Data
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "mail")
})
public class User {

    /** Unique identifier for the user. Auto-generated. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Username for login. Must be unique and not blank. */
    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 50, message = "Username must be 3-50 characters")
    private String username;

    /** Password (hashed) for authentication. Not null. */
    @NotBlank(message = "Password is required")
    @Size(min = 6, max = 100, message = "Password must be at least 6 characters")
    private String password;

    /** User's date of birth. Optional field. */
    private String dateOfBirth;

    /** Gender of the user. Optional field. */
    private String gender;

    /** User's phone number. Optional. */
    private String phoneNumber;

    /** Email of the user. Must be unique and valid. */
    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String mail;

    /** First name of the user. Optional. */
    private String firstname;

    /** Last name of the user. Optional. */
    private String lastname;

    /** Country code of the user. Optional. */
    private String countryCode;

    /** Embedded address details. Optional. */
    @Embedded
    private Address address;

    /** Indicates whether the account is active. Defaults to true. */
    private boolean isActive = true;

    /** Indicates whether the account is locked. Defaults to false. */
    private boolean isLocked = false;

    /** Timestamp of the user's last login. Optional. */
    private LocalDateTime lastLoginAt;
}
