package com.issuetracker.repository;

import com.issuetracker.domain.DetailedComment;
import com.issuetracker.repository.mapper.CommentMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.issuetracker.repository.sql.CommentQueriesKt.FIND_ALL_COMMENT_BY_ISSUE_ID;

@Repository
public class CommentRepository {

    private NamedParameterJdbcTemplate jdbc;

    public CommentRepository(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<DetailedComment> findAllCommentByIssueId(Long issueId) {

        Map<String, Long> paramter = Collections.singletonMap("issueId", issueId);

        List<DetailedComment> commentList = jdbc.query(FIND_ALL_COMMENT_BY_ISSUE_ID, paramter, new CommentMapper());
        
        return commentList;
    }

}
