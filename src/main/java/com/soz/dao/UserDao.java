package com.soz.dao;

import com.soz.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import sun.security.timestamp.TSRequest;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("select count(*) from tb_userinfo where nickname=#{name}")
    public int findName(String name);

    @Insert("insert into tb_userinfo (nickname,password,picture,authority) values (#{name},#{password},#{picture},#{authority})")
    public void add(String name,String password,String picture,String authority);

    @Update("update tb_userinfo set picture = #{url} where nickname = #{name}")
    public void addPhoto(String url,String name);

    @Select("select * from tb_userinfo where nickname = #{name}")
    public User findAll(String name);

    @Select("select password from tb_userinfo where nickname = #{name}")
    public User checkLogin(String name);

    @Select("select picture from tb_userinfo where nickname = #{name}")
    public String showPhoto(String name);

    @Update("update tb_userinfo set nickname = #{name},password=#{password},email=#{email} where id=#{id}")
    void update(String name, String password,String email,Integer id);

    @Select("select id from tb_userinfo where nickname=#{name}")
    int chechId(String name);
}
