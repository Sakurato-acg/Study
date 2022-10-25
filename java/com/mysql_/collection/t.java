package com.mysql_.collection;

import java.sql.*;

public class t {
    public static void main(String[] args) throws Exception {
        //1.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.用户信息和URL
        String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
        String username = "root";
        String password = "1234567890Qq";
        //3.连接成功，数据库对象
        Connection conn = DriverManager.getConnection(url, username, password);

        //4.执行sql的对象
        Statement statement = conn.createStatement();

        //5.执行sql
        String sql = "select * from customers";
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println("id\t" + "name\t" + "email\t" + "birth\t" + "photo\t");
        while (resultSet.next()) {

            System.out.printf("%-3s\t%-5s\t%-8s\t%-8s\t%-8s\t%n",
                       resultSet.getObject("id"),
                       resultSet.getObject("name"),
                       resultSet.getObject("email"),
                       resultSet.getObject("birth") ,
                       resultSet.getObject("photo"));

        }

        //6.释放
        resultSet.close();
        statement.close();
        conn.close();

    }
}
