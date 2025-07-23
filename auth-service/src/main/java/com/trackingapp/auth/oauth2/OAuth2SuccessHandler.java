package com.trackingapp.auth.config;

import com.trackingapp.auth.model.AuthProvider;
import com.trackingapp.auth.model.Role;
import com.trackingapp.auth.model.User;
import com.trackingapp.auth.repository.UserRepository;
import com.trackingapp.auth.security.JwtService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {
    private final JwtService jwtService;
    private final UserRepository userRepository;
    @Lazy
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        OAuth2User oAuth2User=(OAuth2User) authentication.getPrincipal();
        String email=oAuth2User.getAttribute("email");
        String name=oAuth2User.getAttribute("name");

        Optional<User> optionalUser=userRepository.findByUsernameOrEmail(email,email);
        if(optionalUser.isEmpty()){
            User newUser=User.builder()
                    .email(email)
                    .username(name!=null?name:email)
                    .role(Role.ROLE_USER)
                    .enabled(true)
                    .approved(true)
                    .authProvider(AuthProvider.GOOGLE)
                    .build();
            userRepository.save(newUser);
        }

        String token=jwtService.generateToken(email, Role.ROLE_USER);
        response.sendRedirect("http://localhost:4200/oauth-success?token="+token);
    }
}
