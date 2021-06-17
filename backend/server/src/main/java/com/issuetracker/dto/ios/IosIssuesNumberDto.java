package com.issuetracker.dto.ios;

import com.issuetracker.domain.IssuesNumber;

//TODO. 네이밍 변경해야함.
// 클라이언트가 복수개로 선택한 이슈 번호를 서버로 리퀘스트 보낼 때 매칭되는 dto
public class IosIssuesNumberDto {

    private Long[] issueNumber;

    public IosIssuesNumberDto(Long[] issueNumber) {
        this.issueNumber = issueNumber;
    }

    public IssuesNumber toIssueNumber() {
        return new IssuesNumber(issueNumber);
    }

    public Long[] getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(Long[] issueNumber) {
        this.issueNumber = issueNumber;
    }
}
