package com.issuetracker.dto.web;

import java.time.LocalDateTime;

public class WebMilestoneSummaryDto {

    private final Long id;

    private final WebMilestoneInfo milestoneInfo;

    public WebMilestoneSummaryDto(Long id, WebMilestoneInfo milestoneInfo) {
        this.id = id;
        this.milestoneInfo = milestoneInfo;
    }

    public static WebMilestoneSummaryDto from(WebMilestoneDto milestone) {
        return new WebMilestoneSummaryDto(milestone.getId(), milestone.getMilestoneInfo());
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return milestoneInfo.getTitle();
    }

    public String getDescription() {
        return milestoneInfo.getDescription();
    }

    public LocalDateTime getDueDate() {
        return milestoneInfo.getDueDate();
    }
}
