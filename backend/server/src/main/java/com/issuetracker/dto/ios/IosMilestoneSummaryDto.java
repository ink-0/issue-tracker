package com.issuetracker.dto.ios;

import java.time.LocalDateTime;

public class IosMilestoneSummaryDto {

    private final Long id;

    private final IosMilestoneInfo milestoneInfo;

    public IosMilestoneSummaryDto(Long id, IosMilestoneInfo milestoneInfo) {
        this.id = id;
        this.milestoneInfo = milestoneInfo;
    }

    public static IosMilestoneSummaryDto from(IosMilestoneDto milestone) {
        return new IosMilestoneSummaryDto(milestone.getId(), milestone.getMilestoneInfo());
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
