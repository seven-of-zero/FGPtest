package com.soz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/game")
public class GameController {

    @RequestMapping("/game")
    public String game(){
        return "game";
    }

}
