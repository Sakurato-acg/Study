package com.mysql_.util;

import com.mysql_.bean.Customer;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * @author lpl
 * @Description
 * @Date 23:03 2022/7/19
 * @Param
 * @Return
 **/
@SuppressWarnings("all")
public class JDBCutils {

    /**
     * @author lpl
     * @Description 获取数据库的连接
     * @Date 23:08 2022/7/19
     * @Param getConnection
     * @Return Collection
     **/

    public static Connection getConnection() throws Exception {

        //获取配置文件
        InputStream is = ClassLoader.getSystemClassLoader().
                getResourceAsStream("com/mysql_/collection/jdbc_properties");
        Properties pros = new Properties();
        pros.load(is);

        //读取配置文件
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        //注册驱动
        Class.forName(driverClass);

        //登陆连接
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    /**
     * @author lpl
     * @Description 关闭资源
     * @Date 23:13 2022/7/19
     * @Param conn, ps
     * @Return
     **/

    public static void closeResource(Connection conn, Statement ps) {
        //7.关闭资源
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeResource(Connection conn, Statement ps, ResultSet resultSet) {
        //7.关闭资源
        try {
            if (resultSet != null)
                resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void update(String sql, Object... obj) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCutils.getConnection();

            ps = conn.prepareStatement(sql);

            for (int i = 0; i < obj.length; i++) {
                ps.setObject(i + 1, obj[i]);
            }
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCutils.closeResource(conn, ps);
        }
    }

    public static void show(String sql, Object... obj) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        ArrayList<Customer> arr = new ArrayList<>();


        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                ps.setObject(i + 1, obj[i]);
            }

            resultSet = ps.executeQuery();
            //获取结果集的元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                Customer customer = new Customer();
                for (int i = 0; i < columnCount; i++) {

                    Object value = resultSet.getObject(i + 1);

                    String columnName = metaData.getColumnLabel(i + 1);


                    //通过反射 来赋值
                    Field field = Customer.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(customer, value);
                }
                arr.add(customer);
            }

            for (Customer customer : arr) {
                System.out.println(customer.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            closeResource(conn, ps, resultSet);

        }

    }

    public static void show(Connection conn,String sql, Object... obj) {

        PreparedStatement ps = null;
        ResultSet resultSet = null;
        ArrayList<Customer> arr = new ArrayList<>();


        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                ps.setObject(i + 1, obj[i]);
            }

            resultSet = ps.executeQuery();
            //获取结果集的元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                Customer customer = new Customer();
                for (int i = 0; i < columnCount; i++) {

                    Object value = resultSet.getObject(i + 1);

                    String columnName = metaData.getColumnLabel(i + 1);


                    //通过反射 来赋值
                    Field field = Customer.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(customer, value);
                }
                arr.add(customer);
            }

            for (Customer customer : arr) {
                System.out.println(customer.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            closeResource(null, ps, resultSet);

        }

    }
}
