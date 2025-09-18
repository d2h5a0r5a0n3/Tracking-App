package com.tracking.app.auth.microservice.model.embeddable;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Embeddable class representing an Address.
 *
 * <p>This can be embedded inside other entities such as {@code User}
 * to store address information in the same table.</p>
 *
 * <p>All fields are optional but size constraints are added for basic validation.</p>
 *
 * Author: Dharaneshwar
 */
@Embeddable
@Data
public class Address {

    /** Street address (optional, up to 100 characters). */
    @Size(max = 100, message = "Street can be up to 100 characters")
    private String street;

    /** City name (optional, up to 50 characters). */
    @Size(max = 50, message = "City can be up to 50 characters")
    private String city;

    /** State name (optional, up to 50 characters). */
    @Size(max = 50, message = "State can be up to 50 characters")
    private String state;

    /** ZIP or postal code (optional, up to 20 characters). */
    @Size(max = 20, message = "Zip code can be up to 20 characters")
    private String zipCode;

    /** Country name (optional, up to 50 characters). */
    @Size(max = 50, message = "Country can be up to 50 characters")
    private String country;
}
