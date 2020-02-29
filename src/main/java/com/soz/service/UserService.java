package com.soz.service;

import com.soz.pojo.User;

import java.util.List;

public interface UserService {

    public int findName(String name);

    public void add(String name,String password,String picture,String authority);

    public User findAll(String name);

    public void addPhoto(String url,String name);

    public User checkLogin(String name);

    public String showPhoto(String name);

    void update(String name,String password,String email,Integer id);

    int checkId(String name);

}
