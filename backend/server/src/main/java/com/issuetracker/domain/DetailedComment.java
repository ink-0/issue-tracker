package com.issuetracker.domain;

import java.time.LocalDateTime;

//TODO. DB에서 꺼낸 코멘트 관련 정보를 담는 클래스로 추후 네이밍 변경이 필요함.
public class DetailedComment {

    private LocalDateTime dateTime;

    private String writerId;

    private String content;

    private String name;

    private String email;

    private String profileImageUrl;

    public DetailedComment() {
    }

    public DetailedComment(LocalDateTime dateTime, String writerId, String content, String name, String email, String profileImageUrl) {
        this.dateTime = dateTime;
        this.writerId = writerId;
        this.content = content;
        this.name = name;
        this.email = email;
        this.profileImageUrl = profileImageUrl;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getWriterId() {
        return writerId;
    }

    public String getContent() {
        return content;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setWriterId(String writerId) {
        this.writerId = writerId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }
}
