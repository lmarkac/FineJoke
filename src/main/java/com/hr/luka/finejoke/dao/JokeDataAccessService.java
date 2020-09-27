package com.hr.luka.finejoke.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class JokeDataAccessService implements JokeDao{

    private final JdbcTemplate jdbcTemplate;

    public JokeDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int submitJoke(String content, String category) {

        final String sqlFetchCategoryId = "SELECT id FROM category WHERE name LIKE '?'";

        Optional<Integer> id = getId(category, sqlFetchCategoryId);

        final String sql = "INSERT INTO joke (id, name) VALUES (?, ?);";

        Object[] args = new Object[] {id, category};

        return jdbcTemplate.update(sql, args);
    }

    private Optional getId(String category, String sqlFetchCategoryId) {
        return jdbcTemplate.queryForObject(sqlFetchCategoryId, new Object[]{category}, Optional.class);
    }

    @Override
    public int deleteJokeById(UUID id) {
        return 0;
    }

    @Override
    public void modifyJokeById(UUID id) {

    }
}
