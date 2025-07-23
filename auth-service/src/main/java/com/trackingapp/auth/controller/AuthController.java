package com.trackingapp.auth.controller;

import com.trackingapp.auth.dto.LoginRequest;
import com.trackingapp.auth.dto.LoginResponse;
import com.trackingapp.auth.dto.RegisterRequest;
import com.trackingapp.auth.model.Role;
import com.trackingapp.auth.model.User;
import com.trackingapp.auth.repository.UserRepository;
import com.trackingapp.auth.security.JwtService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsernameOrEmail(),
                            loginRequest.getPassword()
                    )
            );
            User user = userRepository.findByUsernameOrEmail(loginRequest.getUsernameOrEmail(), loginRequest.getUsernameOrEmail())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            if(!user.isEnabled()){
                return ResponseEntity.badRequest().body("User not enabled");
            }
            if(!user.isApproved()){
                return ResponseEntity.badRequest().body("User not approved");
            }

            String token= jwtService.generateToken(
                    user.getEmail(),
                    user.getRole()
            );

            return ResponseEntity.ok(new LoginResponse(token,user.getUsername(),user.getRole()));
        }catch (AuthenticationException e){
            throw new BadCredentialsException("Invalid Credentials");
        }
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request){
        if(userRepository.findByUsernameOrEmail(request.getUsername(),request.getEmail()).isPresent()){
            return ResponseEntity.badRequest().body("User already exist");
        }
        User user=User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ROLE_USER)
                .authProvider(null)
                .enabled(true)
                .approved(true)
                .build();
        userRepository.save(user);
        return ResponseEntity.ok(Map.of("message", "User registered successfully"));
    }
}
