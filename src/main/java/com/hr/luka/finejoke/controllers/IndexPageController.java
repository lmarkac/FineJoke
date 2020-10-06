package com.hr.luka.finejoke.controllers;

import com.hr.luka.finejoke.entity.Joke;
import com.hr.luka.finejoke.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class IndexPageController {

    JokeService jokeService;

    @Autowired
    public IndexPageController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @GetMapping("/")
    public String index(Model model){

        List<Joke> jokeList = jokeService.getAllJokes();
        List<List<Joke>> allJokesPaginated = jokeService.getJokesPaginated(jokeList);

        model.addAttribute("allJokes", jokeList);
        model.addAttribute("allCategories", jokeService.getAllCategories());
        model.addAttribute("allJokesPaginated", allJokesPaginated);
        model.addAttribute("numberOfPages", allJokesPaginated.size());
        model.addAttribute("firstJokePage", allJokesPaginated.get(0));

        return "index";
    }

    @GetMapping(path = "/page/{id}")
    public String getCertainJokePage(@PathVariable("id") int id, Model model){
        try{
            model.addAttribute("currentPage", jokeService.getCertainJokePage(id));
            model.addAttribute("currentPageNumber", id);
            return index(model);
        }catch (RuntimeException e){
            System.out.println("The requested page does not exist. Perhaps the path is wrong?");
        }

        return null;
    }


}
