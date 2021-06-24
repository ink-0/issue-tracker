package com.issuetracker.repository;

import com.issuetracker.domain.Comment;
import com.issuetracker.domain.Comments;
import com.issuetracker.domain.Writer;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class CommentRepository {
    private final NamedParameterJdbcTemplate jdbc;

    public CommentRepository(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Comments findByIssueId(Long issueId) {
        String sql = "SELECT comment.id, comment.issueId, dateTime, comment.writerId, comment.content, user.name, user.profileImageUrl "
                + "FROM comment "
                + "INNER JOIN user ON comment.writerId = user.id "
                + "INNER JOIN issue ON comment.issueId = issue.id "
                + "WHERE comment.issueId = :issueId";

        Map<String, Long> params = Collections.singletonMap("issueId", issueId);

        List<Comment> commentList = jdbc.query(sql, params, (rs, rowNum) -> {
            Writer writer = new Writer(rs.getString("name"), rs.getString("profileImageUrl"));

            return new Comment(rs.getLong("id"),
                    rs.getLong("issueId"),
                    writer,
                    rs.getString("content"),
                    rs.getTimestamp("datetime").toLocalDateTime());
        });

        return new Comments(commentList);
    }
}
