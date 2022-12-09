package com.itheima.web;

import com.itheima.Mapper.UserMapper;
import com.itheima.Utils.UtilsMapper;
import com.itheima.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class LoginTest extends BaseServlet{
    @Test
    public void  login(){
        String username="admin";
        String password="admin";
        SqlSession sqlSession = UtilsMapper.sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User login = mapper.login(username, password);

        System.out.println("login = " + login);
    }
}
