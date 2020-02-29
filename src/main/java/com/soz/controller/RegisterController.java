package com.soz.controller;

import com.soz.pojo.User;
import com.soz.service.UserService;
import com.soz.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/reciveUserName")
    @ResponseBody
    public String reciveUserName(String name){
        int count = userService.findName(name);
        String msg = "";
        if (count>0){
            msg = "用户名已存在";
        }else {
            msg = "OK";
        }
        return msg;
    }

    @RequestMapping("/reciveRegister")
    public String reciveRegister(@RequestParam(name = "uname") String name, @RequestParam(name = "upwd") String password, HttpSession session, Model model){
        String picture = "http://127.0.0.1:8080/upload/2020-02-25/2020-02-25-0ab4e5c1-f45c-42fd-ad0b-337f1fad7ff0.jpg";//默认头像
        String authority = "normal";//默认为普通用户
        userService.add(name,password,picture,authority);
        int id = userService.checkId(name);
        session.setAttribute("id",id);
        session.setAttribute("name",name);
        session.setAttribute("password",password);
        session.setAttribute("picture",picture);
        session.setAttribute("authority",authority);
        model.addAttribute("name",name);
        return "next";
    }

}
