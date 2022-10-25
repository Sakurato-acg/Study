package com.mysql_.preparedstatement_;

import com.mysql_.util.JDBCutils;
import org.junit.jupiter.api.Test;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class crud {
    public static void main(String[] args) throws Exception {
        String sql="delete from ? where id=?";
        JDBCutils.update(sql,21);
//        Object []obj=new Object[3];
//        obj[0]="娜扎";
//        obj[1]="nazha@qq.com";
////       SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
////        Date date = new Date(System.currentTimeMillis());
////        String format = sdf.format(date);
////        Date date1 = sdf.parse(format);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = sdf.parse("2002-12-21");
//        obj[2]=new java.sql.Date(date.getTime());
    }
    //增
    @Test
    public void insert()  {

        Connection conn=null;
        PreparedStatement ps =null;
        try {
            InputStream is = ClassLoader.getSystemClassLoader().
                    getResourceAsStream("com/mysql_/collection/jdbc_properties");

            Properties properties = new Properties();
            properties.load(is);

            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");
            String driverClass = properties.getProperty("driverClass");
            //2.加载驱动
            Class.forName(driverClass);
            //3.获取连接
             conn = DriverManager.getConnection(url, user, password);
//        System.out.println(conn);
            //4.预编译sql语句
            String sql="insert into customers(name,email,birth)value(?,?,?)";
             ps = conn.prepareStatement(sql);
            //5.填充占位符
            ps.setString(1,"娜扎");
            ps.setString(2,"nazha@qq.com");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse("2002-12-21");
            ps.setDate(3,  new java.sql.Date(date.getTime()));

            //6.执行sql
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //7.关闭资源
            try {
                if (ps !=null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn !=null){
                conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



    }

    //改
    @Test
    public void update(){

        Connection conn=null;
        PreparedStatement ps =null;
        try {
            conn = JDBCutils.getConnection();
            String sql= " UPDATE test.customers SET  email=? WHERE   id = ?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,"210019@qq.com");
            ps.setInt(2,19);
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCutils.closeResource(conn,ps);
        }
    }
    //删
    @Test
    public void remove(){
        Connection conn=null;
        PreparedStatement ps=null;
        try {
             conn = JDBCutils.getConnection();
             String sql="delete from customers where id=20";
             ps=conn.prepareStatement(sql);
             ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCutils.closeResource(conn,ps);
        }

    }

    //查
    @Test
    public void show(){
        String sql="select  id,name,email,birth\n" +
                "from customers where id=10 ;";
        JDBCutils.show(sql);
    }
}
