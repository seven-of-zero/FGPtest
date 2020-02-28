package com.soz.controller;


import com.soz.pojo.User;
import com.soz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/perfect")
public class PerfectController {

    @Autowired
    private UserService userService;

    @RequestMapping("/addDetail")
    public String addDetail(Model model, HttpSession session){
        String name = (String)session.getAttribute("name");
        String password = (String)session.getAttribute("password");
        Integer id = (Integer)session.getAttribute("id");
        System.out.println(name);
        model.addAttribute("name",name);
        model.addAttribute("password",password);
        model.addAttribute("id",id);
        return "photo";
    }

    @RequestMapping("/showPhoto")
    @ResponseBody
    public String showPhoto(HttpSession session){
        String  name = (String)session.getAttribute("name");
        String picture = userService.showPhoto(name);
        return picture;
    }

    @RequestMapping("/change")
    public String change(@RequestParam(name = "name") String name,
                         @RequestParam(name = "password") String password,
                         @RequestParam(name = "email") String email,
                         HttpSession session){
        Integer id = (Integer) session.getAttribute("id");

        return "redirect:/";
    }

}
