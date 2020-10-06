package com.hr.luka.finejoke.controllers;

import com.hr.luka.finejoke.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/")
public class LikeDislikeAndPaginationController {

    JokeService jokeService;
    IndexPageController indexPageController;

    @Autowired
    public LikeDislikeAndPaginationController(JokeService jokeService, IndexPageController indexPageController) {
        this.jokeService = jokeService;
        this.indexPageController = indexPageController;
    }

    @PutMapping(path = "/like/{id}")
    public void like(@PathVariable("id") int id){
        jokeService.like(id);
    }

    @PutMapping(path = "/dislike/{id}")
    public void dislike(@PathVariable("id") int id){
        jokeService.dislike(id);
    }

    @GetMapping(path = "/page/{id}")
    public String getCertainJokePage(@PathVariable("id") int id, Model model){
        try{
            model.addAttribute("currentPage", jokeService.getCertainJokePage(id));
            model.addAttribute("currentPageNumber", id);
            return indexPageController.index(model);
        }catch (RuntimeException e){
            System.out.println("The requested page does not exist. Perhaps the path is wrong?");
        }

        return null;
    }

}
