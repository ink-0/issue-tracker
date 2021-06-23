package com.issuetracker.repository;

import com.issuetracker.domain.Label;
import com.issuetracker.repository.mapper.LabelMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.issuetracker.repository.sql.LabelQueriesKt.FIND_ALL_LABEL;
import static com.issuetracker.repository.sql.LabelQueriesKt.FIND_ALL_LABEL_BY_ISSUE_ID;

@Repository
public class LabelRepository implements MyRepository<Label> {

    private NamedParameterJdbcTemplate jdbc;

    public LabelRepository(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Label> findAllByIssueId(Long issueId) {

        Map<String, Long> parameter = Collections.singletonMap("issueId", issueId);

        List<Label> labels = jdbc.query(FIND_ALL_LABEL_BY_ISSUE_ID, parameter, new LabelMapper());
        return labels;
    }

    @Override
    public List<Label> findAll() {

        List<Label> labels = jdbc.query(FIND_ALL_LABEL, Collections.emptyMap(), new LabelMapper());
        return labels;
    }

    @Override
    public void save() {

    }
    
    @Override
    public void update(Label label, Long id) {

    }

    @Override
    public void delete(Long id) {

    }
}
