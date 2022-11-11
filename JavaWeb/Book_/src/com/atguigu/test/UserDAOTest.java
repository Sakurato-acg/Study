package com.atguigu.test;

import com.atguigu.bean.User;
import com.atguigu.dao.UserDAO;
import com.atguigu.dao.impl.UserDAOImpl;
import org.junit.jupiter.api.Test;
class UserDAOTest {
    UserDAO userDAO=new UserDAOImpl();

    @Test
    void queryByUsername() {
        User user = userDAO.queryByUsername("admin");
        if (user!=null){
            System.out.println("user = " + user);
            System.out.println("已被注册");
        }else {
            System.out.println("未被注册");
        }
    }

    @Test
    void queryByUsernameAndPassword() {
        User user = userDAO.queryByUsernameAndPassword("admin", "admin");
        if (user==null){
            System.out.println("无账号信息，去注册");
        }else{
            System.out.println("查询成功，能登陆");
        }
    }

    @Test
    void saveUser() {
        int saveUser = userDAO.saveUser(new User(null, "lpl", "123456", "wzg@qq.com"));
        System.out.println(saveUser);
    }
}