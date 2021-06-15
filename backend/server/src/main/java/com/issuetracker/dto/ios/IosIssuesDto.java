package com.issuetracker.dto.ios;

import com.issuetracker.domain.Issues;

import java.util.List;
import java.util.stream.Collectors;

public class IosIssuesDto {
    private final List<IosIssueDto> issues;

    public IosIssuesDto(List<IosIssueDto> issues) {
        this.issues = issues;
    }

    public static IosIssuesDto from(Issues issues) {
        return new IosIssuesDto(issues.toList().stream()
                .map(IosIssueDto::from)
                .collect(Collectors.toList()));
    }

    public List<IosIssueDto> getIssues() {
        return issues;
    }
}
