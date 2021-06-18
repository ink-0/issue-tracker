package com.issuetracker.dto.ios;

import com.issuetracker.domain.Issues;

import java.util.List;
import java.util.stream.Collectors;

public class IosIssuesDto {
    private final List<IosIssueSummaryDto> issues;

    public IosIssuesDto(List<IosIssueSummaryDto> issues) {
        this.issues = issues;
    }

    public static IosIssuesDto from(Issues issues) {
        return new IosIssuesDto(issues.toList().stream()
                .map(IosIssueSummaryDto::from)
                .collect(Collectors.toList()));
    }

    public List<IosIssueSummaryDto> getIssues() {
        return issues;
    }
}
