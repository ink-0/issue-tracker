package com.issuetracker.service.ios;

import com.issuetracker.dto.auth.UserDto;
import com.issuetracker.dto.ios.IosIssuesDto;
import com.issuetracker.repository.IssueRepository;
import org.springframework.stereotype.Service;

@Service
public class IosIssueService {
    private final IssueRepository issueRepository;

    public IosIssueService(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    public IosIssuesDto getIssues(UserDto userDto, String issueStatus) {
        final String ISSUE_CLOSE = "close";

        if (issueStatus.equals(ISSUE_CLOSE)) {
            return IosIssuesDto.from(issueRepository.getClosedIssues(userDto.toUser()));
        }
        return IosIssuesDto.from(issueRepository.getOpenIssues(userDto.toUser()));
    }
}
