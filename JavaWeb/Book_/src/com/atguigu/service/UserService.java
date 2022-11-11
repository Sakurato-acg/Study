package com.atguigu.service;

import com.atguigu.bean.User;

public interface UserService {
    //业务 登陆 注册 检查是否存在

    /**
     * @author lpl
     * @Description
     * @date 0:39 2022/10/23
     * 注册用户
     * @param user
     **/
    public void register(User user);

    //登陆
    public User login(User user);

    //检查用户名是否存在
    public boolean check(String username);
}
