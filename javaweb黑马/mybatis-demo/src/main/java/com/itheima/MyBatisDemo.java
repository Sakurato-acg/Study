package com.itheima;

import com.itheima.Utils.BaseMybatis;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisDemo extends BaseMybatis {

//    public static void main(String[] args) throws IOException {
//        //1.加载核心配置文件，获取sqlSessionFactory
//        String resource="mybatis-config.xml";
//        InputStream inputStream= Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//
//
//        //2.获取sqlSession对象，用来执行sql
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//
//        //3.获取接口代理对象
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        User users = mapper.select("李四","234");
//
//        System.out.println("users = " + users);
//        sqlSession.close();
//    }
}
