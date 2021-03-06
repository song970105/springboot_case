package com.atguigu.springboot;

import com.atguigu.springboot.pojo.User;
import com.atguigu.springboot.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;
    @Test
    public void findAll(){
        List<User> all = userService.findAll();
        System.out.println("all = " + all);
    };
}
