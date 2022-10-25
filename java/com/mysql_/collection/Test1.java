package com.mysql_.collection;

import com.alibaba.druid.proxy.DruidDriver;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
    }
    @Test
    //1。连接方式1
    public void testCollection1() throws SQLException {
        //1.添加驱动
        Driver driver = new DruidDriver();
        //2.编写相关信息
        String url = "jdbc:mysql://localhost:3306/" +
                "test?characterEncoding=utf8" +
                "&useSSL=false" +
                "&serverTimezone=UTC" +
                "&rewriteBatchedStatements=true";
        Properties info =new Properties();
        info.setProperty("user","root");
        info.setProperty("password","1234567890Qq" );
        //3.连接成功，数据库对象
        Connection conn = driver.connect(url, info);

        System.out.println(conn);
    }
    @Test
    //2.连接方式2
    public void testCollection2() throws Exception{
        //1.加载驱动 反射实现
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");

        Driver driver = (Driver) aClass.newInstance();

        //2.提供要连接的数据库
        String url = "jdbc:mysql://localhost:3306/" +
                "test?characterEncoding=utf8" +
                "&useSSL=false" +
                "&serverTimezone=UTC" +
                "&rewriteBatchedStatements=true";
        //3.用户名与密码
        Properties info =new Properties();
        info.setProperty("user","root");
        info.setProperty("password","1234567890Qq" );
        //4.获取连接
        Connection conn = driver.connect(url, info);
        System.out.println(conn);
    }

    @Test
    //连接方式3 DriverManager
    public void testCollection3() throws Exception{
        //1.注册驱动
        Class <?>  aClass = Class.forName("com.mysql.cj.jdbc.Driver");

        Driver driver = (Driver) aClass.newInstance();

        //2.提供要连接的数据库
        String url = "jdbc:mysql://localhost:3306/" +
                "test?characterEncoding=utf8" +
                "&useSSL=false" +
                "&serverTimezone=UTC" +
                "&rewriteBatchedStatements=true";
        //3.用户名与密码
        String username = "root";
        String password = "1234567890Qq";
        //4.获取连接
        DriverManager.registerDriver(driver);
        Connection conn = DriverManager.getConnection(url,username,password);

        System.out.println(conn);
    }

    //连接方式4 优化3
    @Test
    public void testCollection4() throws Exception{
        //1.注册驱动
          Class.forName("com.mysql.cj.jdbc.Driver");

        //2.提供要连接的数据库
        String url = "jdbc:mysql://localhost:3306/" +
                "test?characterEncoding=utf8" +
                "&useSSL=false" +
                "&serverTimezone=UTC" +
                "&rewriteBatchedStatements=true";
        //3.用户名与密码
        String username = "root";
        String password = "1234567890Qq";
        //4.获取连接

        Connection conn = DriverManager.getConnection(url,username,password);

        System.out.println(conn);
    }

    //连接方式 5 读配置文件
    @Test
    public void testCollection5() throws Exception{
        //1.读取配置文件
        InputStream is = Test1.class.
                getClassLoader().
                getResourceAsStream("com/mysql_/collection/jdbc_properties");
        Properties properties = new Properties();
        properties.load(is);

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driverClass = properties.getProperty("driverClass");
//------------------------------------------//
        Class.forName(driverClass);

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }
}
