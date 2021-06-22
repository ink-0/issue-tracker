package com.issuetracker.controller.web;

import com.issuetracker.dto.auth.UserDto;
import com.issuetracker.dto.web.*;
import com.issuetracker.service.AuthService;
import com.issuetracker.service.web.WebIssueService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/web")
public class WebIssueController {

    private final AuthService authService;
    private final WebIssueService webIssueService;

    public WebIssueController(AuthService authService, WebIssueService webIssueService) {
        this.authService = authService;
        this.webIssueService = webIssueService;
    }

    @GetMapping("/issues")
    public WebIssuesDto getIssues(UserDto user, @RequestParam(value = "status", required = false) String issueStatus, @RequestParam(required = false) String milestone, @RequestParam(required = false) String writer, @RequestParam(required = false) String created) {
        return webIssueService.getIssues(user, issueStatus);
    }


    //TODO. 로직 미구현
    @PatchMapping("/issues")
    public void closeIssue(@RequestBody WebIssuesNumbersDto issueNumber) {
        webIssueService.toggleIssue(issueNumber); //TODO. toggle 네이밍 변경 필요해보임.
    }

    //INFO. 이슈생성 버튼 클릭시 제공해주는 요소(담당자, 레이블, 마일스톤 리스트..)
    @GetMapping("/issues/form")
    public WebIssueOptionDto makeIssuePage() {
        return webIssueService.findIssueOption();
    }

    @PostMapping("/issues")
    public void createIssue(@RequestBody WebNewIssueDto issue) {
        webIssueService.save(issue); // console print
    }

    /*
    @GetMapping("/issues/{issueId}")
    public WebIssueDetailDto detailIssue(@PathVariable Long issueId) {
        return webIssueService.findDetailedIssueId(issueId);
    }
    */

    @GetMapping("/issues/{issueId}/comments")
    public WebCommentsDto commentList(@PathVariable Long issueId) {
        return webIssueService.findAllCommentByIssueId(issueId);
    }

}
