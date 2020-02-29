package com.soz.controller;


import com.soz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(HttpSession session, Model model){
        String name = (String)session.getAttribute("name");
        String photo = userService.showPhoto(name);
        System.out.println(photo);
        model.addAttribute("name",name);
        model.addAttribute("url",photo);
        return "index";
    }

}
