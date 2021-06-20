package com.issuetracker.dto.auth;

public class AuthRequest {
    private String code;

    protected AuthRequest() {}

    public AuthRequest(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
