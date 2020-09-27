package com.hr.luka.finejoke.service;

import com.hr.luka.finejoke.dao.JokeDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    private final JokeDao jokeDao;

    public CategoryService(@Qualifier("postgres") JokeDao jokeDao) {
        this.jokeDao = jokeDao;
    }

    public int submitJoke(String content, String category) {
        return jokeDao.submitJoke(content, category);
    }
}
