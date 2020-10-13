package com.hr.luka.finejoke.controllers;

import com.hr.luka.finejoke.service.JokeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")

public class LikeAndDislikeRestController {

    private static final Logger logger = LoggerFactory.getLogger(LikeAndDislikeRestController.class);
    JokeService jokeService;

    @Autowired
    public LikeAndDislikeRestController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @PutMapping(path = "/like/{id}")
    public void like(@PathVariable("id") int id){
        logger.info("like");
        jokeService.like(id);
    }

    @PutMapping(path = "/dislike/{id}")
    public void dislike(@PathVariable("id") int id){
        logger.info("dislike");
        jokeService.dislike(id);
    }

}
