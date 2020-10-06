package com.hr.luka.finejoke.dao;

import com.hr.luka.finejoke.entity.Category;
import com.hr.luka.finejoke.entity.Joke;
import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
        String sqlInsert = "INSERT INTO joke (category_id, content) VALUES (?, ?)";
        return jdbcTemplate.update(sqlInsert, new Object[]{joke.getCategory_id(), joke.getContent()});

    }

    private Optional getId(String category, String sqlFetchCategoryId) {
        return jdbcTemplate.queryForObject(sqlFetchCategoryId, new Object[]{category}, Optional.class);
    }

    public List<Joke> getAllJokes(){

        String sqlFetchJokes = "SELECT * FROM joke ORDER BY (likes - dislikes) DESC;";

        jokeList = jdbcTemplate.query(sqlFetchJokes, (resultSet, rowNumber) ->{

           int id = resultSet.getInt("id");
           int category_id = resultSet.getInt("category_id");
           String content = resultSet.getString("content");
           int likes = resultSet.getInt("likes");
           int dislikes = resultSet.getInt("dislikes");

           return new Joke(id, category_id, content, likes, dislikes);
        });

        return jokeList;
    }

    public List<List<Joke>> getJokesPaginated(List<Joke> jokeList) {
        List<List<Joke>> jokeListPaginated = ListUtils.partition(jokeList, 10);
        return jokeListPaginated;
    }

    public List<Joke> getCertainJokePage(int pageNumber){

        String sqlFetchJokes = null;

        if(pageNumber == 1){
            sqlFetchJokes = "SELECT * FROM joke ORDER BY (likes - dislikes) DESC LIMIT 10;";
        }else if(pageNumber > 1){
            sqlFetchJokes = "SELECT * FROM joke ORDER BY (likes - dislikes) DESC LIMIT 10 OFFSET " + --pageNumber * 10 + ";";
        }else{
            System.out.println("jesus wtf sqlFetchJokes je null");
        }

        jokeList = jdbcTemplate.query(sqlFetchJokes, (resultSet, rowNumber) ->{

            int id = resultSet.getInt("id");
            int category_id = resultSet.getInt("category_id");
            String content = resultSet.getString("content");
            int likes = resultSet.getInt("likes");
            int dislikes = resultSet.getInt("dislikes");

            return new Joke(id, category_id, content, likes, dislikes);
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

    public void like(int id){

        String sqlUpdateJoke = "UPDATE joke SET likes = likes + 1 WHERE joke.id = ?";

        jdbcTemplate.update(sqlUpdateJoke, id);
    }

    public void dislike(int id){
        String sqlUpdateJoke = "UPDATE joke SET dislikes = dislikes + 1 WHERE joke.id = ?";

        jdbcTemplate.update(sqlUpdateJoke, id);
    }
}
