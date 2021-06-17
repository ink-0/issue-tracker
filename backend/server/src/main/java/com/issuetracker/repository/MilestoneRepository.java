package com.issuetracker.repository;

import com.issuetracker.domain.Milestone;
import com.issuetracker.domain.Milestones;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class MilestoneRepository {
    public Milestones findAll() {
        
        Milestones milestones = new Milestones();
        milestones.add(new Milestone(1L, "마일트론 제목1", "마일스톤 내용1", LocalDateTime.now()));
        milestones.add(new Milestone(2L, "마일트론 제목2", "마일스톤 내용2", LocalDateTime.now()));
        milestones.add(new Milestone(3L, "마일트론 제목3", "마일스톤 내용3", LocalDateTime.now()));

        return milestones;
    }
}
