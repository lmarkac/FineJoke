package com.hr.luka.finejoke.dao;

import com.hr.luka.finejoke.entity.Category;
import com.hr.luka.finejoke.entity.Joke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class JokeDataAccessService implements JokeDao{

    private final JdbcTemplate jdbcTemplate;

    List<Joke> jokeList;
    List<Category> categoryList;

    @Autowired
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

    public List<Joke> getAllJokes(){

        String sqlFetchJokes = "SELECT * FROM joke ORDER BY (likes - dislikes) DESC;";

        jokeList = jdbcTemplate.query(sqlFetchJokes, (resultSet, rowNumber) ->{
           int id = resultSet.getInt("id");
           String content = resultSet.getString("content");
           int likes = resultSet.getInt("likes");
           int dislikes = resultSet.getInt("dislikes");

           return new Joke(id, content, likes, dislikes);
        });

        return jokeList;
    }

    @Override
    public List<Category> getAllCategories() {
        String sqlFetchCategories = "SELECT * FROM category;";

        categoryList = jdbcTemplate.query(sqlFetchCategories, (resultSet, rowNumber) ->{
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");

            return new Category(id, name);
        });

        return categoryList;
    }

    @Override
    public int deleteJokeById(UUID id) {
        return 0;
    }

    @Override
    public void modifyJokeById(UUID id) {

    }
}
