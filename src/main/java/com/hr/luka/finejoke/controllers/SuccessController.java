package com.hr.luka.finejoke.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/success")
public class SuccessController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String returnHome(){
        return "index";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String returnToJokeForm(){
        return "jokeForm";
    }
}
