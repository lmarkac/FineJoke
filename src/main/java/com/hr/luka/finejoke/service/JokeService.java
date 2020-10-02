package com.hr.luka.finejoke.service;

import com.hr.luka.finejoke.dao.JokeDao;
import com.hr.luka.finejoke.entity.Category;
import com.hr.luka.finejoke.entity.Joke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class JokeService {

    private final JokeDao jokeDao;

    @Autowired
    public JokeService(@Qualifier("postgres") JokeDao jokeDao) {
        this.jokeDao = jokeDao;
    }

    public int submitJoke(Joke joke) {
        return jokeDao.submitJoke(joke);
    }

    public void like(int id){
        jokeDao.like(id);
    }

    public void dislike(int id){
        jokeDao.dislike(id);
    }

    public List<Joke> getAllJokes(){
        return jokeDao.getAllJokes();
    }

    public List<Category> getAllCategories(){
        return jokeDao.getAllCategories();
    }



}
