package com.issuetracker.dto.ios;

import com.issuetracker.domain.IssueOption;

//INFO, 새로운 이슈 작성할 때, [담당자, 레이블, 마일스톤] 보여주는 건대, 네이밍 변경이 필요해보임.
public class IosIssueOptionDto {

    private IosAssigneesDto assigneesDto;

    private IosLabelsDto labelsDto;

    private IosMilestonesDto milestonesDto;

    public static IosIssueOptionDto from(IssueOption issueOption) {
        return new IosIssueOptionDto(IosAssigneesDto.from(issueOption.getAssignees()), IosLabelsDto.from(issueOption.getLabels()), IosMilestonesDto.from(issueOption.getMilestones()));
    }

    public IosIssueOptionDto(IosAssigneesDto assigneesDto, IosLabelsDto labelsDto, IosMilestonesDto milestonesDto) {
        this.assigneesDto = assigneesDto;
        this.labelsDto = labelsDto;
        this.milestonesDto = milestonesDto;
    }

    public IosAssigneesDto getAssigneesDto() {
        return assigneesDto;
    }

    public IosLabelsDto getLabelsDto() {
        return labelsDto;
    }

    public void setAssigneesDto(IosAssigneesDto assigneesDto) {
        this.assigneesDto = assigneesDto;
    }

    public void setLabelsDto(IosLabelsDto labelsDto) {
        this.labelsDto = labelsDto;
    }

    public IosMilestonesDto getMilestonesDto() {
        return milestonesDto;
    }

    public void setMilestonesDto(IosMilestonesDto milestonesDto) {
        this.milestonesDto = milestonesDto;
    }
}
