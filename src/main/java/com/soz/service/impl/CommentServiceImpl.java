package com.soz.service.impl;

import com.soz.dao.CommentDao;
import com.soz.pojo.Comment;
import com.soz.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public void add(Comment comment) {
       commentDao.add(comment);
    }

    @Override
    public List<Comment> show(Integer article) {
        List<Comment> comments = commentDao.show(article);
        return comments;
    }
}
