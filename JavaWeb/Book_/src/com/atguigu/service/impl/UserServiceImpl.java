package com.atguigu.service.impl;

import com.atguigu.bean.User;
import com.atguigu.dao.UserDAO;
import com.atguigu.dao.impl.UserDAOImpl;
import com.atguigu.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO=new UserDAOImpl();
    @Override
    public void register(User user) {
        boolean check = check(user.getUsername());
        if (!check){
            userDAO.saveUser(user);
        }
    }

    @Override
    @SuppressWarnings("all")
    public User login(User user) {
        User usernameAndPassword = userDAO.queryByUsernameAndPassword(user.getUsername(), user.getPassword());
        return usernameAndPassword;
    }

    //ture 已存在相关信息
    //false 可加
    @Override
    public boolean check(String username) {
        if (userDAO.queryByUsername(username)==null){
            return false;
        }else {
         return true;
        }
    }
}
