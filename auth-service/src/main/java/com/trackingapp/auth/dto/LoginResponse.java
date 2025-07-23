package com.trackingapp.auth.dto;

import com.trackingapp.auth.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponse {
    private String token;
    private String username;
    private Role role;
}
