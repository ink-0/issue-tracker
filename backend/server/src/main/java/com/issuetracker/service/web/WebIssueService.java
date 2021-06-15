package com.issuetracker.service.web;

import com.issuetracker.dto.auth.UserDto;
import com.issuetracker.dto.web.WebIssuesDto;
import com.issuetracker.repository.IssueRepository;
import org.springframework.stereotype.Service;

@Service
public class WebIssueService {
    private final IssueRepository issueRepository;

    public WebIssueService(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    public WebIssuesDto getIssues(UserDto userDto) {
        return WebIssuesDto.from(issueRepository.getIssues(userDto.toUser()));
    }
}
