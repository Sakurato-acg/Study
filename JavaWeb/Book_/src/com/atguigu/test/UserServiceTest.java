package com.atguigu.test;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    UserService userService=new UserServiceImpl();
    @Test
    void register() {
        User user = new User(null, "2120400146", "210019", "285834773@qq.com");
        userService.register(user);
    }

    @Test
    void login() {
        User login = userService.login(new User(null, "2120400146", "210019", "285834773@qq.com"));
        System.out.println("login = " + login);
    }

    @Test
    void check() {
        boolean check = userService.check("2120400146");
        if (check){
            System.out.println("用户名已存在");
        }else{
            System.out.println("用户名不存在");
        }
    }
}