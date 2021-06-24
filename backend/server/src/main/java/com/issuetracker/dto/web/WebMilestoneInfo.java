package com.issuetracker.dto.web;

import com.issuetracker.domain.MilestoneInfo;

import java.time.LocalDateTime;

public class WebMilestoneInfo {

    private String title;

    private String description;

    private String status;

    private LocalDateTime dueDate;

    public WebMilestoneInfo(String title, String description, String status, LocalDateTime dueDate) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
    }

    public static WebMilestoneInfo from(MilestoneInfo milestoneInfo) {
        return new WebMilestoneInfo(milestoneInfo.getTitle(), milestoneInfo.getDescription(), milestoneInfo.getStatus().name(), milestoneInfo.getDueDate());
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }
}
