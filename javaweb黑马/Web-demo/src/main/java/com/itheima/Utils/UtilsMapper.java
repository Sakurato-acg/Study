package com.itheima.Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class UtilsMapper {

    //1.加载核心配置文件，获取sqlSessionFactory
    public static String resource = "mybatis-config.xml";
    public static InputStream inputStream;

    static {
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    public static void commitAndClose(SqlSession sqlSession) {
        sqlSession.commit();
        sqlSession.close();
    }
    //2.获取sqlSession对象，用来执行sql

}
