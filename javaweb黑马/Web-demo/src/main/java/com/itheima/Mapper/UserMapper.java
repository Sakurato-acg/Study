package com.itheima.Mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Param;
@SuppressWarnings("all")
public interface UserMapper {

    /**
     * @param username
     * @param password
     * @return
     */
    public User login(@Param("username") String username, @Param("password") String password);

    public void register(User user);

    public User checkUsername(@Param("username") String username);
}
