package com.issuetracker.controller.ios;

import com.issuetracker.dto.auth.UserDto;
import com.issuetracker.dto.ios.IosIssueOptionDto;
import com.issuetracker.dto.ios.IosIssuesDto;
import com.issuetracker.dto.ios.IosIssuesNumberDto;
import com.issuetracker.dto.ios.IosNewIssueDto;
import com.issuetracker.service.AuthService;
import com.issuetracker.service.ios.IosIssueService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ios")
public class IosIssueController {

    private final AuthService authService;
    private final IosIssueService iosIssueService;

    public IosIssueController(AuthService authService, IosIssueService iosIssueService) {
        this.authService = authService;
        this.iosIssueService = iosIssueService;
    }

    @GetMapping("/issues")
    public IosIssuesDto getIssues(UserDto user, @RequestParam("status") String issueStatus) {
        return iosIssueService.getIssues(user, issueStatus);
    }

    //로직 미구현
    @PatchMapping("/issues")
    public void closeIssue(@RequestBody IosIssuesNumberDto issueNumber) {
        iosIssueService.toggleIssue(issueNumber); //TODO. toggle 네이밍 변경 필요해보임.
    }

    // 이슈생성 버튼 클릭시 제공해주는 요소(담당자, 레이블, 마일스톤 리스트..)
    @GetMapping("/issues/form")
    public IosIssueOptionDto makeIssuePage() {
        return iosIssueService.findIssueOption();
    }

    @PostMapping("/issues")
    public void createIssue(@RequestBody IosNewIssueDto issue) {
        iosIssueService.save(issue); // console print
    }

}
