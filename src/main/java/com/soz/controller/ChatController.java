package com.soz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
public class ChatController {

    @RequestMapping("/chat")
    public String chat(HttpSession session, Model model){
        String name = (String)session.getAttribute("name");
        if (name!=null){
            model.addAttribute("name",name);
            return "testChat";
        }else {
            model.addAttribute("msg","请先登录");
            return "error";
        }
    }


}
