package com.issuetracker.service.ios;

import com.issuetracker.dto.auth.UserDto;
import com.issuetracker.dto.ios.IosIssueDto;
import com.issuetracker.repository.IssueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IosIssueService {
    private final IssueRepository issueRepository;

    public IosIssueService(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    public List<IosIssueDto> getIssues(UserDto userDto) {
        return issueRepository.getIssues(userDto.toUser())
                .stream().map(IosIssueDto::from)
                .collect(Collectors.toList());
    }
}
