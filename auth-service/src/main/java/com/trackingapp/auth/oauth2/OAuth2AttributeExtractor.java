package com.trackingapp.auth.oauth2;

public interface OAuthUserInfo {
    String getEmail();
    String getName();
    String getProviderId();
}
