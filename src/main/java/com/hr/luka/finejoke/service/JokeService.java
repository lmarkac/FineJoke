package com.hr.luka.finejoke.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class JokeService {

    private  List<String> testList = new ArrayList<>();

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
