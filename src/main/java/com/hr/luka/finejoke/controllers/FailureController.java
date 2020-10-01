package com.hr.luka.finejoke.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/failure")
public class FailureController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String returnHome(){
        return "index";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String returnToJokeForm(){
        return "jokeForm";
    }
}
