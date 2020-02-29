package com.soz.controller;

import com.soz.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class PublishController {

    @Autowired
    private ActivityService activityService;

    @RequestMapping("/fabu")
    public String publish(HttpSession session, Model model){
        String name = (String) session.getAttribute("name");
        if (name!=null){
            model.addAttribute("name",name);
            return "publish";
        }else {
            model.addAttribute("msg","请先登录");
            return "error";
        }

    }

    @RequestMapping("/publish")
    public String getPublish(@RequestParam(name = "title")String title,@RequestParam(name = "description")String content,HttpSession session){
        String name = (String)session.getAttribute("name");
        Date date = new Date();
        activityService.add(title,content,date,name);
        return "redirect:/activity";
    }




}
