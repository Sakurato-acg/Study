package com.atguigu.dao.impl;

import com.atguigu.bean.User;
import com.atguigu.dao.UserDAO;

public class UserDAOImpl extends BaseDAO implements UserDAO {
    @Override
    public User queryByUsername(String username) {
        String sql="select id, username, password, email " +
                "from book.t_user where username=?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public User queryByUsernameAndPassword(String username,String password) {
        String sql="select id, username, password, email " +
                "from book.t_user where username=? and password=?";
        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql="insert into book.t_user (username, password, email) values (?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
