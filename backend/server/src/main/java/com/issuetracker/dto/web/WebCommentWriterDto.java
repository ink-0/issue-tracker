package com.issuetracker.dto.web;

import java.util.List;

public class WebCommentWriterDto {

    private String name;

    private String profileImageUrl;

    private List<String> emails;

    public WebCommentWriterDto(String name, String profileImageUrl, List<String> emails) {
        this.name = name;
        this.profileImageUrl = profileImageUrl;
        this.emails = emails;
    }
    
    public String getName() {
        return name;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public List<String> getEmails() {
        return emails;
    }
}
