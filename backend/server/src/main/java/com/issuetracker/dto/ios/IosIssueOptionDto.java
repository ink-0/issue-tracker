package com.issuetracker.dto.ios;

import com.issuetracker.domain.IssueOption;
import com.issuetracker.dto.auth.UserDto;

import java.util.List;

//INFO, 새로운 이슈 작성할 때, [담당자, 레이블, 마일스톤] 보여주는 건대, 네이밍 변경이 필요해보임.
public class IosIssueOptionDto {

    private final IosAssigneesDto assignees;

    private final IosLabelsDto labels;

    private final IosMilestonesDto milestones;

    public static IosIssueOptionDto from(IssueOption issueOption) {
        return new IosIssueOptionDto(IosAssigneesDto.from(issueOption.getAssignees()), IosLabelsDto.from(issueOption.getLabels()), IosMilestonesDto.from(issueOption.getMilestones()));
    }

    public IosIssueOptionDto(IosAssigneesDto assignees, IosLabelsDto labels, IosMilestonesDto milestones) {
        this.assignees = assignees;
        this.labels = labels;
        this.milestones = milestones;
    }

    public List<UserDto> getAssignees() {
        return assignees.getUsers();
    }

    public List<IosLabelDto> getLabels() {
        return labels.getLabels();
    }

    public List<IosMilestoneDto> getMilestones() {
        return milestones.getMilestones();
    }
}
