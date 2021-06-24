package com.issuetracker.dto.ios;

import com.issuetracker.domain.Assignees;

import java.util.List;
import java.util.stream.Collectors;

public class IosAssigneesDto {

    private final List<IosAssigneeDto> assignees;

    public IosAssigneesDto(List<IosAssigneeDto> assignees) {
        this.assignees = assignees;
    }

    public static IosAssigneesDto from(Assignees assignees) {
        return new IosAssigneesDto(assignees.toList().stream()
                .map(IosAssigneeDto::from)
                .collect(Collectors.toList()));
    }

    public List<IosAssigneeDto> toList() {
        return assignees;
    }

    public Assignees toAssignees() {
        return new Assignees(assignees.stream()
                .map(IosAssigneeDto::toAssignee)
                .collect(Collectors.toList()));
    }
}
