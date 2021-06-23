package com.issuetracker.repository;

import com.issuetracker.domain.Comment;
import com.issuetracker.domain.CommentWriter;
import com.issuetracker.domain.Comments;
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

    public Comments findAllCommentByIssueId(Long issueId) {

        Map<String, Long> paramter = Collections.singletonMap("issueId", issueId);

        List<Comment> commentList = jdbc.query(FIND_ALL_COMMENT_BY_ISSUE_ID, paramter, (rs, rowNum) -> {
            CommentWriter commentWriter = new CommentWriter(rs.getString("name"), rs.getString("profileImageUrl"));

            return new Comment(rs.getLong("id"),
                    rs.getLong("issueId"),
                    commentWriter,
                    rs.getString("content"),
                    rs.getTimestamp("datetime").toLocalDateTime());
        });

        return new Comments(commentList);
    }

}
