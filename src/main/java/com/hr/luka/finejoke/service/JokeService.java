package com.hr.luka.finejoke.service;

import com.hr.luka.finejoke.dao.JokeDao;
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

    public int submitJoke(String content, String category) {
        return jokeDao.submitJoke(content, category);
    }

    private List<String> testList = new ArrayList<>();

    public List<String> getTestList() {
        return testList;
    }

    @PostConstruct
    public void populateList(){
        System.out.println("adding options...");
        testList.add("Op1");
        testList.add("Op2");
        testList.add("Op3");
    }

}
