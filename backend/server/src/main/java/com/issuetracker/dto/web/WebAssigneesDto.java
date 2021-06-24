package com.issuetracker.dto.web;

import com.issuetracker.domain.Assignees;

import java.util.List;
import java.util.stream.Collectors;

public class WebAssigneesDto {

    private final List<WebAssigneeDto> assignees;

    public WebAssigneesDto(List<WebAssigneeDto> assignees) {
        this.assignees = assignees;
    }

    public static WebAssigneesDto from(Assignees assignees) {
        return new WebAssigneesDto(assignees.toList().stream()
                .map(WebAssigneeDto::from)
                .collect(Collectors.toList()));
    }

    public List<WebAssigneeDto> toList() {
        return assignees;
    }

    public Assignees toAssignees() {
        return new Assignees(assignees.stream()
                .map(WebAssigneeDto::toAssignee)
                .collect(Collectors.toList()));
    }
}
