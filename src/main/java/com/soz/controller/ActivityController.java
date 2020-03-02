package com.soz.controller;

import com.soz.pojo.ActPojo;
import com.soz.pojo.Comment;
import com.soz.service.ActivityService;
import com.soz.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private CommentService commentService;

    @RequestMapping("/activity")
    public String show(Model model){
        List<ActPojo> pojos = activityService.showTitle();//将所有的活动都放在一个List列表中集中展示
        model.addAttribute("pojos",pojos);//通过model携带参数到前端页面展示
        return "activity";
    }


    @RequestMapping("/test/{id}")
    public String test(@PathVariable(name = "id")Integer id, Model model){
        ActPojo act = activityService.show(id);
        List<Comment> comments = commentService.show(id);
        int size = comments.size();
        model.addAttribute("size",size);
        model.addAttribute("list",comments);
        model.addAttribute("act",act);
        return "test";
    }



}
