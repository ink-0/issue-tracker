package com.issuetracker.dto.ios;

import com.issuetracker.domain.NewIssue;

import java.util.List;
import java.util.stream.Collectors;

public class IosNewIssueDto {

    private String title;

    private String comment;

    private IosAssigneesDto assignees;

    private IosLabelsDto labels;

    private Long milestoneId;

    public IosNewIssueDto(String title, String comment, List<IosAssigneeDto> assignees, List<IosLabelDto> labels, Long milestoneId) {
        this.title = title;
        this.comment = comment;
        this.assignees = new IosAssigneesDto(assignees);
        this.labels = new IosLabelsDto(labels);
        this.milestoneId = milestoneId;
    }

    public static IosNewIssueDto from(NewIssue newIssue) {
        List<IosAssigneeDto> assignees = newIssue.getAssignees().toList().stream().map(IosAssigneeDto::from).collect(Collectors.toList());
        List<IosLabelDto> labels = newIssue.getLabels().toList().stream().map(IosLabelDto::from).collect(Collectors.toList());

        return new IosNewIssueDto(newIssue.getTitle(), newIssue.getComment(), assignees, labels, newIssue.getMilestoneId());
    }

    public NewIssue toNewIssue() {
        return new NewIssue(title, comment, assignees.toAssignees(), labels.toLabels(), milestoneId);
    }

    public String getTitle() {
        return title;
    }

    public String getComment() {
        return comment;
    }

    public List<IosAssigneeDto> getAssignees() {
        return assignees.toList();
    }

    public List<IosLabelDto> getLabels() {
        return labels.toList();
    }

    public Long getMilestoneId() {
        return milestoneId;
    }
}
