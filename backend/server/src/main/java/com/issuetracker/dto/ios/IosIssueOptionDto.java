package com.issuetracker.dto.ios;

import com.issuetracker.domain.IssueOption;
import com.issuetracker.dto.auth.UserDto;

import java.util.List;

//INFO, 새로운 이슈 작성할 때, [담당자, 레이블, 마일스톤] 보여주는 건대, 네이밍 변경이 필요해보임.
public class IosIssueOptionDto {

    private final IosAssigneesDto assigneesDto;

    private final IosLabelsDto labelsDto;

    private final IosMilestonesDto milestonesDto;

    public static IosIssueOptionDto from(IssueOption issueOption) {
        return new IosIssueOptionDto(IosAssigneesDto.from(issueOption.getAssignees()), IosLabelsDto.from(issueOption.getLabels()), IosMilestonesDto.from(issueOption.getMilestones()));
    }

    public IosIssueOptionDto(IosAssigneesDto assigneesDto, IosLabelsDto labelsDto, IosMilestonesDto milestonesDto) {
        this.assigneesDto = assigneesDto;
        this.labelsDto = labelsDto;
        this.milestonesDto = milestonesDto;
    }

    public List<UserDto> getAssignees() {
        return assigneesDto.getUsers();
    }

    public List<IosLabelDto> getLabels() {
        return labelsDto.getLabels();
    }

    public List<IosMilestoneDto> getMilestones() {
        return milestonesDto.getMilestones();
    }
}
