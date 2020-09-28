package com.hr.luka.finejoke.dao;

import com.hr.luka.finejoke.entity.Category;
import com.hr.luka.finejoke.entity.Joke;

import java.util.List;
import java.util.UUID;

public interface JokeDao {

    int submitJoke(String content, String category);
    int deleteJokeById(UUID id);
    void modifyJokeById(UUID id);
    List<Joke> getAllJokes();
    List<Category> getAllCategories();
}
