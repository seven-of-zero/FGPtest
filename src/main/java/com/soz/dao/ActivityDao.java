package com.soz.dao;

import com.soz.pojo.ActPojo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import java.util.Date;
import java.util.List;

@Mapper
public interface ActivityDao {

    @Insert("insert into tb_activity(title,content,time,publisher) value(#{title},#{content},#{date},#{publisher})")
    void add(String title, String content, Date date,String publisher);

    @Select("select * from tb_activity where id=#{id}")
    ActPojo show(Integer id);

    @Delete("delete from tb_activity where id=#{id}")
    void delete(Integer id);

    @Select("select * from tb_activity")
    List<ActPojo> showTitle();

}
