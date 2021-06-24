package com.issuetracker.repository;

import com.issuetracker.domain.MilestoneInfo;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

import static com.issuetracker.repository.sql.MilestoneQueriesKt.FIND_ALL_MILESTONE;

@Repository
public class MilestoneRepository {

    private final NamedParameterJdbcTemplate jdbc;

    public MilestoneRepository(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<MilestoneInfo> findAllMilestoneInfo() {

        List<MilestoneInfo> milestonesInfo = jdbc.query(FIND_ALL_MILESTONE, Collections.emptyMap(), (rs, rowNum) -> new MilestoneInfo(
                rs.getString("title"),
                rs.getString("description"),
                rs.getTimestamp("dueDate").toLocalDateTime()));

        return milestonesInfo;
    }
}
