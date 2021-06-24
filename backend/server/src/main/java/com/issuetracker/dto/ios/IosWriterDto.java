package com.issuetracker.dto.ios;

import com.issuetracker.domain.Writer;

public class IosWriterDto {
    private final String name;
    private final String profileImageUrl;

    public IosWriterDto(String name, String profileImageUrl) {
        this.name = name;
        this.profileImageUrl = profileImageUrl;
    }

    public String getName() {
        return name;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public static IosWriterDto from(Writer writer) {
        return new IosWriterDto(writer.getName(), writer.getProfileImageUrl());
    }
}
