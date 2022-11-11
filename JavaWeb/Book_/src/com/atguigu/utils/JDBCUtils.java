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

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            conn = source.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeResource_(Connection conn) {
        if (conn != null)
            DbUtils.closeQuietly(conn);
    }

    public static void closeResource_(Connection conn, Statement statement) {
        if (conn != null)
            DbUtils.closeQuietly(conn);
        DbUtils.closeQuietly(statement);
    }
}
