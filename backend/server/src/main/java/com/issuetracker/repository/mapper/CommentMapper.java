package com.issuetracker.repository.mapper;

import com.issuetracker.domain.DetailedComment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentMapper implements RowMapper<DetailedComment> {
    @Override
    public DetailedComment mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new DetailedComment(
                rs.getTimestamp("dateTime").toLocalDateTime(),
                rs.getString("writerId"),
                rs.getString("content"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("profileImageUrl")
        );
    }
}
