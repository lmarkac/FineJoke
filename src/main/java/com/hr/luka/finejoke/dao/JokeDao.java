package com.hr.luka.finejoke.dao;

import com.hr.luka.finejoke.entity.Category;
import com.hr.luka.finejoke.entity.Joke;

import java.util.List;
import java.util.UUID;

public interface JokeDao {

    int submitJoke(Joke joke);
    List<Joke> getAllJokes();
    List<Category> getAllCategories();
    void like(int id);
    void dislike(int id);
    List<Joke> getCertainJokePage(int page);
    List<List<Joke>> getJokesPaginated(List<Joke> jokeList);
}
