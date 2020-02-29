package com.soz.service;

import com.soz.pojo.Comment;

import java.util.List;

public interface CommentService {

    void add(Comment comment);

    List<Comment> show(Integer article);

}
