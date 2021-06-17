package com.issuetracker.dto.web;

import com.issuetracker.domain.Milestones;

import java.util.List;
import java.util.stream.Collectors;

public class WebMilestonesDto {

    private final List<WebMilestoneDto> milestones;

    public WebMilestonesDto(List<WebMilestoneDto> milestones) {
        this.milestones = milestones;
    }

    public static WebMilestonesDto from(Milestones milestones) {
        return new WebMilestonesDto(milestones.toList().stream().map(WebMilestoneDto::from).collect(Collectors.toList()));
    }

    public List<WebMilestoneDto> getMilestones() {
        return milestones;
    }
}
