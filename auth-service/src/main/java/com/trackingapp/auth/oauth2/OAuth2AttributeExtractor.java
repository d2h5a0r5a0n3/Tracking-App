package com.trackingapp.auth.oauth2;

import org.springframework.security.oauth2.core.user.OAuth2User;

public interface OAuth2AttributeExtractor {
    String extractEmail(OAuth2User oAuth2User);
    String extractName(OAuth2User oAuth2User);
    String getProvider();
}
