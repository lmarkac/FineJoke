package com.hr.luka.finejoke.dao;

import java.util.UUID;

public interface JokeDao {

    int submitJoke(String content, String category);
    int deleteJokeById(UUID id);
    void modifyJokeById(UUID id);

}
