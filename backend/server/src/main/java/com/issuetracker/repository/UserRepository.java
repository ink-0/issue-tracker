package com.issuetracker.repository;

import com.issuetracker.domain.auth.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void save(User user) {
        String sql = "INSERT INTO `user` (`id`, `name`, `profileImageUrl`) values (?, ?, ?) "
                + "ON DUPLICATE KEY UPDATE `name` = ?, `profileImageUrl` = ?";
        jdbcTemplate.update(sql, user.getId(), user.getName(), user.getProfileImageUrl(), user.getName(), user.getProfileImageUrl());
    }
}
