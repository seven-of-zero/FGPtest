package com.soz.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GithubDao {

    @Insert("insert into tb_userinfo(nickname,picture) values(#{name},#{picture})")
    void add(String name,String picture);

    @Select("select count(*) from tb_userinfo where nickname=#{name}")
    int checkExsist(String name);

}
