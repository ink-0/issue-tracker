package com.issuetracker.repository;

import com.issuetracker.domain.auth.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Transactional
    public void save(User user) {
        saveUser(user);
        saveEmail(user);
    }

    private void saveUser(User user) {
        String sql = "INSERT INTO `user` (`id`, `name`, `profileImageUrl`) values (?, ?, ?) "
                + "ON DUPLICATE KEY UPDATE `name` = ?, `profileImageUrl` = ?";
        jdbcTemplate.update(sql, user.getId(), user.getName(), user.getProfileImageUrl(), user.getName(), user.getProfileImageUrl());
    }

    private void saveEmail(User user) {
        int batchSize = 100;
        String userId = user.getId();
        String sql = "INSERT INTO `email` (`email`, `userId`) values (?, ?) "
                + "ON DUPLICATE KEY UPDATE `userId` = ?";
        jdbcTemplate.batchUpdate(sql, user.getEmails(), batchSize,
                (ps, email) -> {
                    ps.setString(1, email);
                    ps.setString(2, userId);
                    ps.setString(3, userId);
                });
    }
}
