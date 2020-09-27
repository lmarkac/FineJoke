package com.hr.luka.finejoke.controllers;

import com.hr.luka.finejoke.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class JokeFormController {

    @Autowired
    JokeService jokeService;

    @GetMapping("/new")
    public String jokeForm(Model model){
        model.addAttribute("jokeContentField", "Joke Content");
        model.addAttribute("categories", jokeService.getTestList());
        return "jokeForm";
    }
}
