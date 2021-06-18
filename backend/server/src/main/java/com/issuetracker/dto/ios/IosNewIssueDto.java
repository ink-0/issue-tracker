package com.issuetracker.dto.ios;

import com.issuetracker.domain.NewIssue;
import com.issuetracker.dto.auth.UserDto;

import java.util.List;

public class IosNewIssueDto {

    private String title;

    private String comment;

    private IosAssigneesDto assignees;

    private IosLabelsDto labels;

    private Long milestoneId;

    public IosNewIssueDto(String title, String comment, IosAssigneesDto assignees, IosLabelsDto labels, Long milestoneId) {
        this.title = title;
        this.comment = comment;
        this.assignees = assignees;
        this.labels = labels;
        this.milestoneId = milestoneId;
    }

    public static IosNewIssueDto from(NewIssue newIssue) {
        return new IosNewIssueDto(newIssue.getTitle(), newIssue.getComment(), IosAssigneesDto.from(newIssue.getAssignees()), IosLabelsDto.from(newIssue.getLabels()), newIssue.getMilestoneId());
    }

    public NewIssue toNewIssue() {
        return new NewIssue(title, comment, assignees.toUsers(), labels.toLabels(), milestoneId);
    }

    public String getTitle() {
        return title;
    }

    public String getComment() {
        return comment;
    }

    public List<UserDto> getAssignees() {
        return assignees.toList();
    }

    public List<IosLabelDto> getLabels() {
        return labels.toList();
    }

    public Long getMilestoneId() {
        return milestoneId;
    }
}
