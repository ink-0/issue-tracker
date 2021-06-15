package com.issuetracker.service.web;

import com.issuetracker.dto.auth.UserDto;
import com.issuetracker.dto.web.WebIssueDto;
import com.issuetracker.repository.IssueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WebIssueService {
    private final IssueRepository issueRepository;

    public WebIssueService(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    public List<WebIssueDto> getIssues(UserDto userDto) {
        return issueRepository.getIssues(userDto.toUser())
                .stream().map(WebIssueDto::from)
                .collect(Collectors.toList());
    }
}
