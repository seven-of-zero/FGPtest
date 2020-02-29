package com.soz.dao;

import com.soz.pojo.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentDao {

    @Insert("insert into tb_comment() values(#{username},#{comment},#{article})")
    void add(Comment comment);

    @Select("select * from tb_comment where article=#{article}")
    List<Comment> show(Integer article);

}
