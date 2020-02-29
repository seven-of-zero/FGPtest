package com.soz.dao;


import com.soz.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestDao {

    @Autowired
    private UserDao userDao;

    @Test
    public void test(){
        User user = userDao.findAll("root");
        System.out.println(user.getId());
        System.out.println(user.getNickname());
        System.out.println(user.getPassword());
        System.out.println(user.getPicture());
    }

}
