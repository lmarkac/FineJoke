package com.hr.luka.finejoke.form;

import com.hr.luka.finejoke.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class JokeForm {

    @Autowired
    JokeService jokeService = new JokeService();

    @GetMapping("/new")
    public String home(Model model){
        model.addAttribute("jokeContentField", "Joke Content");
        model.addAttribute("categories", jokeService.getTestList());
        return "jokeForm";
    }

}
