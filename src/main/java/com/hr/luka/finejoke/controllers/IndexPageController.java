package com.hr.luka.finejoke.controllers;

import com.hr.luka.finejoke.entity.Category;
import com.hr.luka.finejoke.entity.Joke;
import com.hr.luka.finejoke.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class IndexPageController {

    @Autowired
    JokeService jokeService;
    
    public IndexPageController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @GetMapping("/")
    public String index(Model model){

        List<Joke> allJokes = jokeService.getAllJokes();
        List<Category> allCategories = jokeService.getAllCategories();

        model.addAttribute("allJokes", allJokes);
        model.addAttribute("allCategories", allCategories);

        return "index";
    }
}
