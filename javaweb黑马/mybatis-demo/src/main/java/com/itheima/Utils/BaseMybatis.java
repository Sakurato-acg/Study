package com.itheima.Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class BaseMybatis {
    //1.加载核心配置文件，获取sqlSessionFactory
    public String resource = "mybatis-config.xml";
    public InputStream inputStream;

    {
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    //2.获取sqlSession对象，用来执行sql
    public SqlSession sqlSession = sqlSessionFactory.openSession();


    public void commitAndClose(){
        sqlSession.commit();
        sqlSession.close();
    }
}
