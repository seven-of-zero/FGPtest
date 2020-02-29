package com.soz.service;

import com.soz.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestService {

    @Autowired
    private UserService userService;

    @Test
    public void test(){
        User root = userService.findAll("root");
        System.out.println(root.getId());
        System.out.println(root.getNickname());
        System.out.println(root.getPicture());
    }

}
