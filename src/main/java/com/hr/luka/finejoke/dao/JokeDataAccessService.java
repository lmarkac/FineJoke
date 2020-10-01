package com.hr.luka.finejoke.dao;

import com.hr.luka.finejoke.controllers.JokeFormController;
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
    public int submitJoke(Joke joke) throws RuntimeException{
        String sqlInsert = "INSERT INTO joke (id, content) VALUES (?, ?)";
        return jdbcTemplate.update(sqlInsert, new Object[]{joke.getId(), joke.getContent()});

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

    public int like(Joke joke){
        String sqlUpdateJoke = "UPDATE joke SET likes = ? WHERE joke.content LIKE ?";
        System.out.println("Ušo");

        return jdbcTemplate.update(sqlUpdateJoke, joke.getLikes() + 1, joke.getContent());
    }

    public int dislike(Joke joke){
        return 0;
    }

}
