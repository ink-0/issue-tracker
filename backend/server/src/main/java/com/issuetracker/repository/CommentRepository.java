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
                "WHERE 1=1\n" +
                "AND comment.issueId = :issueId\n" +
                "AND NOT email.email REGEXP 'users.noreply.github.com';";
        //INFO. 유저가 기본 이메일외 추가적인 이메일을 등록하지 않았다고 가정하고, noreply 이메일을 제외하고 검색하면 이메일 한개만 검색됨.

        Map<String, Long> paramter = Collections.singletonMap("issueId", issueId);

        List<DetailedComment> commentList = jdbc.query(sql, paramter, rowMapper);


        return commentList;
    }

}
