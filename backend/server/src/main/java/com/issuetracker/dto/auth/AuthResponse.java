package com.issuetracker.dto.auth;

public class AuthResponse {
    private final String token;
    private final String name;
    private final String profileImageUrl;

    public AuthResponse(String token, String name, String profileImageUrl) {
        this.token = token;
        this.name = name;
        this.profileImageUrl = profileImageUrl;
    }
    
    public String getToken() {
        return token;
    }

    public String getName() {
        return name;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }
}
