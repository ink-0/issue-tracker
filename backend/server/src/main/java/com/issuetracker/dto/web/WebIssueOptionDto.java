package com.issuetracker.dto.web;

import com.issuetracker.domain.IssueOption;
import com.issuetracker.dto.auth.UserDto;

import java.util.List;

//INFO, 새로운 이슈 작성할 때, [담당자, 레이블, 마일스톤] 보여주는 건대, 네이밍 변경이 필요해보임.
public class WebIssueOptionDto {

    private final WebAssigneesDto assignees;

    private final WebLabelsDto labels;

    private final WebMilestonesDto milestones;

    public static WebIssueOptionDto from(IssueOption issueOption) {
        return new WebIssueOptionDto(WebAssigneesDto.from(issueOption.getAssignees()), WebLabelsDto.from(issueOption.getLabels()), WebMilestonesDto.from(issueOption.getMilestones()));
    }

    public WebIssueOptionDto(WebAssigneesDto assignees, WebLabelsDto labels, WebMilestonesDto milestones) {
        this.assignees = assignees;
        this.labels = labels;
        this.milestones = milestones;
    }

    public List<UserDto> getAssignees() {
        return assignees.getUsers();
    }

    public List<WebLabelDto> getLabels() {
        return labels.getLabels();
    }

    public List<WebMilestoneDto> getMilestones() {
        return milestones.getMilestones();
    }
}
