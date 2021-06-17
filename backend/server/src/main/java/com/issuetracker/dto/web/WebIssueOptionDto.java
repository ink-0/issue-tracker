package com.issuetracker.dto.web;

import com.issuetracker.domain.IssueOption;

//INFO, 새로운 이슈 작성할 때, [담당자, 레이블, 마일스톤] 보여주는 건대, 네이밍 변경이 필요해보임.
public class WebIssueOptionDto {

    private WebAssigneesDto assigneesDto;

    private WebLabelsDto labelsDto;

    private WebMilestonesDto milestonesDto;

    public static WebIssueOptionDto from(IssueOption issueOption) {
        return new WebIssueOptionDto(WebAssigneesDto.from(issueOption.getAssignees()), WebLabelsDto.from(issueOption.getLabels()), WebMilestonesDto.from(issueOption.getMilestones()));
    }

    public WebIssueOptionDto(WebAssigneesDto assigneesDto, WebLabelsDto labelsDto, WebMilestonesDto milestonesDto) {
        this.assigneesDto = assigneesDto;
        this.labelsDto = labelsDto;
        this.milestonesDto = milestonesDto;
    }

    public WebAssigneesDto getAssigneesDto() {
        return assigneesDto;
    }

    public void setAssigneesDto(WebAssigneesDto assigneesDto) {
        this.assigneesDto = assigneesDto;
    }

    public WebLabelsDto getLabelsDto() {
        return labelsDto;
    }

    public void setLabelsDto(WebLabelsDto labelsDto) {
        this.labelsDto = labelsDto;
    }

    public WebMilestonesDto getMilestonesDto() {
        return milestonesDto;
    }

    public void setMilestonesDto(WebMilestonesDto milestonesDto) {
        this.milestonesDto = milestonesDto;
    }
}
