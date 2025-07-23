package com.trackingapp.auth.oauth2;

import com.trackingapp.auth.model.AuthProvider;
import com.trackingapp.auth.model.Role;
import com.trackingapp.auth.model.User;
import com.trackingapp.auth.repository.UserRepository;
import com.trackingapp.auth.security.JwtService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
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
    private final OAuth2ExtractorFactory oAuth2ExtractorFactory;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
        String provider = token.getAuthorizedClientRegistrationId();
        OAuth2User oAuth2User = token.getPrincipal();
        OAuth2AttributeExtractor oAuth2AttributeExtractor = oAuth2ExtractorFactory.getExtractor(provider);
        String email = oAuth2AttributeExtractor.extractEmail(oAuth2User);
        String name = oAuth2AttributeExtractor.extractName(oAuth2User);
        if (name == null) name = email;
        Optional<User> optionalUser = userRepository.findByUsernameOrEmail(email, email);
        if (optionalUser.isEmpty()) {
            User newUser = User.builder()
                    .email(email)
                    .username(name)
                    .role(Role.ROLE_USER)
                    .enabled(true)
                    .approved(true)
                    .authProvider(AuthProvider.valueOf(provider.toUpperCase()))
                    .build();
            userRepository.save(newUser);
        }
        String jwt = jwtService.generateToken(email, Role.ROLE_USER);
        response.sendRedirect("http://localhost:4200/oauth-success?token=" + jwt);
    }
}
