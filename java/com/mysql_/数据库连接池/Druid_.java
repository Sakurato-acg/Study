package com.mysql_.数据库连接池;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mysql_.util.JDBCutils;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;

public class Druid_ {

    @Test
    public void getConnection() throws Exception {
        Properties pros = new Properties();

        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("com/mysql_/数据库连接池/druid.properties");

        pros.load(is);

        DataSource source = DruidDataSourceFactory.createDataSource(pros);
        Connection conn = source.getConnection();

        String sql="select  id,name,email,birth\n" +
                "from customers where id=10 ;";
        JDBCutils.show(conn,sql);
        conn.close();

    }
}
