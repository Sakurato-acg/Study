package com.atguigu.dao;

import com.atguigu.bean.User;

public interface UserDAO {


    //根据用户名查询信息
    public User queryByUsername(String username);

    //根据用户名和密码查询信息
    public User queryByUsernameAndPassword(String username,String password);

    //保存用户信息
    public int saveUser(User user);


}
