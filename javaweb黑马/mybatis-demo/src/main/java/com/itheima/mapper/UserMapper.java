package com.itheima.mapper;

import com.itheima.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    public List<User> selectAll();

//    public User select(String username ,String password);
//    public User select(@Param("username") String username ,@Param("password") String password);
//    public User select(@Param("username") Collection collection);

    public User select(Map map);
    User selectById(int id);

}
