package com.trackingapp.auth.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Column(unique = true)
    private String email;
    @Column(nullable = true)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(name="auth_provider")
    private AuthProvider authProvider;

    @Column(name="provider_id")
    private String providerId;

    @Column(name = "is_enabled")
    private boolean enabled;

    @Column(name = "is_approved")
    private boolean approved;
}
