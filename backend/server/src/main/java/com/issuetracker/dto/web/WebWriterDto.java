package com.issuetracker.dto.web;

import com.issuetracker.domain.Writer;

public class WebWriterDto {
    private final String name;
    private final String profileImageUrl;

    public WebWriterDto(String name, String profileImageUrl) {
        this.name = name;
        this.profileImageUrl = profileImageUrl;
    }

    public String getName() {
        return name;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public static WebWriterDto from(Writer writer) {
        return new WebWriterDto(writer.getName(), writer.getProfileImageUrl());
    }
}
