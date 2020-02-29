package com.soz.controller;

import com.soz.pojo.ActPojo;
import com.soz.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ManageController {

    @Autowired
    private ActivityService activityService;

    @RequestMapping("/manage")
    public String manage(Model model){
        List<ActPojo> pojos = activityService.showTitle();
        model.addAttribute("pojos",pojos);
        return "manage";
    }

    @RequestMapping("/delete/{id}")
    public String manage(@PathVariable(name = "id") Integer id){
        activityService.delete(id);
        return "redirect:/manage";
    }

}
