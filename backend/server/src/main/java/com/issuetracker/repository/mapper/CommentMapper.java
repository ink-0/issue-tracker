package com.issuetracker.repository.mapper;

import com.issuetracker.domain.Comment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentMapper implements RowMapper {
    @Override
    public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Comment(rs.getLong("id"),
                rs.getLong("issueId"),
                null,
                rs.getString("content"),
                rs.getTimestamp("dateTime").toLocalDateTime());
    }
}
