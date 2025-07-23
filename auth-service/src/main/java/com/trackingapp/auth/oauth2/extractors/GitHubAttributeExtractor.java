package com.trackingapp.auth.oauth2.extractors;

import com.trackingapp.auth.oauth2.OAuth2AttributeExtractor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

@Component
public class GitHubAttributeExtractor implements OAuth2AttributeExtractor {
    private OAuth2User oAuth2User;

    @Override
    public String extractEmail(OAuth2User oAuth2User) {
        String email = oAuth2User.getAttribute("email");
        return email != null ? email : oAuth2User.getAttribute("login") + "@github-user.fake";
    }

    @Override
    public String extractName(OAuth2User oAuth2User) {
        return oAuth2User.getAttribute("name");
    }

    @Override
    public String getProvider() {
        return "github";
    }
}
