package com.trackingapp.auth.oauth2.extractors;

import com.trackingapp.auth.oauth2.OAuth2AttributeExtractor;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

@Component
public class BitbucketAttributeExtractor implements OAuth2AttributeExtractor {
    @Override
    public String extractEmail(OAuth2User oAuth2User) {
        return oAuth2User.getAttribute("username")+"@bitbucket-user.fake";
    }

    @Override
    public String extractName(OAuth2User oAuth2User) {
        String name=oAuth2User.getAttribute("display_name");
        if(name!=null) return name;
        return oAuth2User.getAttribute("username");
    }

    @Override
    public String getProvider() {
        return "bitbucket";
    }
}
