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

    public IosIssuesDto getIssues(UserDto userDto) {
        return IosIssuesDto.from(issueRepository.getIssues(userDto.toUser()));
    }
}
