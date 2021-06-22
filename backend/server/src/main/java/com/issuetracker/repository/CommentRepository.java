package com.issuetracker.repository;

import com.issuetracker.domain.DetailedComment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class CommentRepository {

    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<DetailedComment> rowMapper = BeanPropertyRowMapper.newInstance(DetailedComment.class);

    public CommentRepository(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<DetailedComment> findAllCommentByIssueId(Long issueId) {

        String sql = "SELECT dateTime, comment.writerId, comment.content, name, email, profileImageUrl\n" +
                "FROM comment\n" +
                "         INNER JOIN user ON comment.writerId = user.id\n" +
                "         INNER JOIN email ON user.id = email.userId\n" +
                "         INNER JOIN issue ON comment.issueId = issue.id\n" +
                "WHERE comment.issueId = :issueId;";

        Map<String, Long> paramter = Collections.singletonMap("issueId", issueId);

        List<DetailedComment> commentList = jdbc.query(sql, paramter, rowMapper);


        return commentList;
    }

}
