package com.issuetracker.repository;

import com.issuetracker.domain.Comment;
import com.issuetracker.domain.Comments;
import com.issuetracker.domain.auth.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Arrays;

@Repository
public class CommentRepository {
    public Comments findByIssueId(Long issueId) {
        User writer = new User("test1", "테스터1", "http://testProfile.image.url", Arrays.asList("a@test1.com", "b@test1.com"));
        User writer2 = new User("test2", "테스터2", "http://testProfile.image.url", Arrays.asList("a@test2.com", "b@test2.com"));
        Comments comments = new Comments();

        comments.add(new Comment(1L, 1L, writer, "댓글내용1", LocalDateTime.now()));
        comments.add(new Comment(2L, 1L, writer2, "댓글내용3", LocalDateTime.now()));
        comments.add(new Comment(3L, 1L, writer2, "댓글내용4", LocalDateTime.now()));

        return comments;
    }
}
