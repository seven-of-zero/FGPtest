package com.soz.dao;

import com.soz.pojo.ActPojo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import java.util.List;

@Mapper
public interface ActivityDao {

    @Insert("insert into tb_activity(title,content,publisher) value(#{title},#{content}.#{publisher})")
    void add(String title,String content,String publisher);

    @Select("select * from tb_activity where id=#{id}")
    List<ActPojo> show(Integer id);

    @Delete("delete from tb_activity where id=#{id}")
    void delete(Integer id);

    @Select("select title from tb_activity")
    List<String> showTitle();

}
