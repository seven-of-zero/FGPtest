package com.soz.controller;

import com.soz.pojo.Comment;
import com.soz.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/getComment")
    public String getComment(@RequestParam(name="cName") String name,@RequestParam(name="cMessage") String comments,@RequestParam(name = "id") Integer id){
        Comment comment = new Comment();
        comment.setArticle(id);
        comment.setComment(comments);
        comment.setUsername(name);
        commentService.add(comment);
        return "redirect:/test/"+id;
    }

}
