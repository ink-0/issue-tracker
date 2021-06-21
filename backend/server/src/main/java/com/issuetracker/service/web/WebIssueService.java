package com.issuetracker.service.web;

import com.issuetracker.domain.Comments;
import com.issuetracker.domain.Issue;
import com.issuetracker.dto.IssueStatusDto;
import com.issuetracker.dto.auth.UserDto;
import com.issuetracker.dto.web.*;
import com.issuetracker.repository.CommentRepository;
import com.issuetracker.repository.IssueRepository;
import org.springframework.stereotype.Service;

@Service
public class WebIssueService {
    private final IssueRepository issueRepository;
    private final CommentRepository commentRepository;

    public WebIssueService(IssueRepository issueRepository, CommentRepository commentRepository) {
        this.issueRepository = issueRepository;
        this.commentRepository = commentRepository;
    }

    public WebIssuesDto getIssues(UserDto userDto, String issueStatus) {

        if (issueStatus == null) {
            issueStatus = IssueStatusDto.ALL.name();
        }

        IssueStatusDto status = IssueStatusDto.valueOf(issueStatus);

        switch (status) {
            case CLOSED:
                return WebIssuesDto.from(issueRepository.getClosedIssues(userDto.toUser()));
            case OPEN:
                return WebIssuesDto.from(issueRepository.getOpenIssues(userDto.toUser()));
            default:
                return WebIssuesDto.from(issueRepository.getAllIssues(userDto.toUser()));
        }
    }

    //INFO.  "issueNumbers": [1, 2, 3] 이 들어오면, 해당 번호의 이슈의 상태를 반전
    //INFO. 아직 repository 완성되지 않음.
    public void toggleIssue(WebIssuesNumbersDto issueNumber) {
        issueRepository.toggle(issueNumber.toIssueNumber()); //TODO. toggle 네이밍 변경 필요해보임.
    }

    public WebIssueOptionDto findIssueOption() {
        return WebIssueOptionDto.from(issueRepository.findIssueOption());
    }

    public void save(WebNewIssueDto issueDto) {
        issueRepository.save(issueDto.toNewIssue());
    }

    public WebIssueDetailDto findDetailedIssueId(Long issueId) {
        Issue issue = issueRepository.findById(issueId);
        Comments comments = commentRepository.findByIssueId(issueId);

        return WebIssueDetailDto.from(issue, comments);
    }

    public WebCommentsDto findCommentsByIssueId(Long issueId) {
        return WebCommentsDto.from(commentRepository.findByIssueId(issueId));
    }

}
