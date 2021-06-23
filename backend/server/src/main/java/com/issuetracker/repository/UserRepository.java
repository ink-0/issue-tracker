package com.issuetracker.repository;

import com.issuetracker.domain.auth.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

import static com.issuetracker.repository.sql.UserQueriesKt.*;

@Repository
public class UserRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, JdbcTemplate jdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void save(User user) {
        saveUser(user);
        saveEmail(user);
    }

    private void saveUser(User user) {
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id", user.getId())
                .addValue("name", user.getName())
                .addValue("profileImageUrl", user.getProfileImageUrl());

        namedParameterJdbcTemplate.update(SAVE_USER, parameters);
    }

    //TODO. NamedJdbcTemplate으로 통일할 수 있으면 하기
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


    //TODO. 이메일 배열을 어떻게 받아야할 지 모르겠음..
    public List<User> findAll() {

        //INFO. 개발을 할 때 N+1이 훨씬 직관적이다. 성능 튜닝은 추후에
        // N+1 동작한다는 것은: 테이블 설계가 잘돼있고, 객체화가 가능하다는 의미
        // 튜닝시 테이블 설계는 변경할 필요 없고, 쿼리만 변경하면 됨.
        // Spring Data JDBC : schema 까지 짜야함. mapper 같은 걸 해주는 걸 이 프레임 워크
        // JDBC Template : mapper
        // 1:n = 유저1: 이메일 복수
        // 레포지토리 설계의 자유가 늘어남 - crud repository에서는 정의된 메소드 따라야함 derived
        return namedParameterJdbcTemplate.query(FIND_ALL_USER, Collections.emptyMap(), (rs, rowNum) -> {

            String userId = rs.getString("userId");
            String name = rs.getString("name");
            String profileImageUrl = rs.getString("profileImageUrl");

            SqlParameterSource parameter = new MapSqlParameterSource().addValue("userId", userId);

            //INFO. 유저마다 이메일 리스트가 필요해서 리스트 정의
            List<String> emails = namedParameterJdbcTemplate.query(FIND_ALL_EMAILS, parameter, (result, rowNumber) -> result.getString("email"));

            return new User(userId, name, profileImageUrl, emails);
        });
    }

}
