package com.hr.luka.finejoke.controllers;

import com.hr.luka.finejoke.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
public class LikeAndDislikeRestController {

    JokeService jokeService;

    @Autowired
    public LikeAndDislikeRestController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @PutMapping(path = "/like/{id}")
    public void like(@PathVariable("id") int id){
        System.out.println("Uso");
        jokeService.like(id);
    }

    @PutMapping(path = "/dislike/{id}")
    public void dislike(@PathVariable("id") int id){
        jokeService.dislike(id);
    }

}
