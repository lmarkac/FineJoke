package com.hr.luka.finejoke.controllers;

import com.hr.luka.finejoke.entity.Joke;
import com.hr.luka.finejoke.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class JokeFormController {

    JokeService jokeService;

    @Autowired
    public JokeFormController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @GetMapping("/new")
    public String jokeForm(Model model){
        model.addAttribute("jokeContentField", "Joke Content");
        model.addAttribute("categories", jokeService.getAllCategories());
        model.addAttribute("joke", new Joke());
        return "jokeForm";
    }


    @PostMapping("/new")
    public String submitJoke(@ModelAttribute("jokeForm") Joke joke) {
        try{
            jokeService.submitJoke(joke);
        }catch(RuntimeException e){
            return "failure";
        }
        return "success";
    }
}
