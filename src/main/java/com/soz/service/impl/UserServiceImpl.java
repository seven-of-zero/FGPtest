package com.soz.service.impl;

import com.soz.dao.UserDao;
import com.soz.pojo.User;
import com.soz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int findName(String name) {
        int count = userDao.findName(name);
        return count;
    }

    @Override
    public void add(String name,String password,String picture,String authority) {

        userDao.add(name,password,picture,authority);
    }

    @Override
    public User findAll(String name) {
        User user = userDao.findAll(name);
        return user;
    }

    @Override
    public void addPhoto(String url, String name) {
        userDao.addPhoto(url,name);
    }

    @Override
    public User checkLogin(String name) {
        User user = userDao.checkLogin(name);
        return user;
    }

    @Override
    public String showPhoto(String name) {
        String picture = userDao.showPhoto(name);
        return picture;
    }

    @Override
    public void update(String name, String password, String email,Integer id) {
        userDao.update(name,password,email,id);
    }

    @Override
    public int checkId(String name) {
        int id = userDao.chechId(name);
        return id;
    }
}
