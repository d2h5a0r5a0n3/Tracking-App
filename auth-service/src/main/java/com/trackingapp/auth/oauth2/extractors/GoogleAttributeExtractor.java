package com.trackingapp.auth.oauth2.extractors;

import com.trackingapp.auth.oauth2.OAuth2AttributeExtractor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GoogleAttributeExtractor implements OAuth2AttributeExtractor {
    @Override
    public String extractEmail(OAuth2User oAuth2User) {
        return oAuth2User.getAttribute("email");
    }

    @Override
    public String extractName(OAuth2User oAuth2User) {
        return oAuth2User.getAttribute("name");
    }

    @Override
    public String getProvider() {
        return "google";
    }
}
