package com.soz.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(HttpSession session, Model model){
        String name = (String)session.getAttribute("name");
        String picture = (String)session.getAttribute("picture");
        model.addAttribute("name",name);
        model.addAttribute("url",picture);
        return "index";
    }

}
