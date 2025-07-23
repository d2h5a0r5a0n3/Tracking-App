package com.trackingapp.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/public")
    public ResponseEntity<?> publicEndpoint() {
        return ResponseEntity.ok("✅ Public API: No auth required");
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> userEndpoint() {
        return ResponseEntity.ok("🔐 Protected API: USER role required");
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> adminEndpoint() {
        return ResponseEntity.ok("🔐 Protected API: ADMIN role required");
    }

    @GetMapping("/dev")
    @PreAuthorize("hasRole('DEV')")
    public ResponseEntity<?> devEndpoint() {
        return ResponseEntity.ok("🔐 Protected API: DEV role required");
    }

    @GetMapping("/org")
    @PreAuthorize("hasRole('ORG')")
    public ResponseEntity<?> orgEndpoint() {
        return ResponseEntity.ok("🔐 Protected API: ORG role required");
    }
}
//1.normal user oauth2
//2.originzation google or micrsoft
//authencator otp+password or authecator approvel
//3.developer then ldap
//4. admin otp and password