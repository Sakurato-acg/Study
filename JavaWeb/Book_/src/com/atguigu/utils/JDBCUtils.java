package com.atguigu.utils;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {

    /**
     * 使用Druid数据库连接池技术
     */
    private static DruidDataSource source;
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    static {
        try {
            Properties pros = new Properties();
            // 读取 jdbc.properties属性配置文件
            InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            // 从流中加载数据
            pros.load(inputStream);
            // 创建 数据库连接 池

            source = (DruidDataSource) DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection()  {
        Connection conn = threadLocal.get();
        if (conn == null) {
            try {
                conn = source.getConnection();
                threadLocal.set(conn);
                conn.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    public static void commitAndClose(){
        Connection connection = threadLocal.get();
        if (connection!=null){
            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        threadLocal.remove();
    }
    public static void rollbackAndClose(){

    }

}
