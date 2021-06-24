package com.issuetracker.dto.web;

import com.issuetracker.domain.IssueOption;

import java.util.List;
import java.util.stream.Collectors;

//INFO, 새로운 이슈 작성할 때, [담당자, 레이블, 마일스톤] 보여주는 건대, 네이밍 변경이 필요해보임.
public class WebIssueOptionDto {

    private final WebAssigneesDto assigneesDto;

    private final WebLabelsDto labelsDto;

    private final WebMilestonesDto milestonesDto;

    public static WebIssueOptionDto from(IssueOption issueOption) {
        return new WebIssueOptionDto(WebAssigneesDto.from(issueOption.getAssignees()), WebLabelsDto.from(issueOption.getLabels()), WebMilestonesDto.from(issueOption.getMilestones()));
    }

    public WebIssueOptionDto(WebAssigneesDto assigneesDto, WebLabelsDto labelsDto, WebMilestonesDto milestonesDto) {
        this.assigneesDto = assigneesDto;
        this.labelsDto = labelsDto;
        this.milestonesDto = milestonesDto;
    }

    public List<WebAssigneeDto> getAssignees() {
        return assigneesDto.toList();
    }

    public List<WebLabelDto> getLabels() {
        return labelsDto.getLabels();
    }

    public List<WebMilestoneSummaryDto> getMilestones() {
        return milestonesDto.getMilestones()
                .stream().map(WebMilestoneSummaryDto::from)
                .collect(Collectors.toList());
    }
}
