package com.mysql_.BLOB;

import com.mysql_.util.JDBCutils;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;

public class Crud {


    @Test
    public void insert(){
        Connection conn=null;
        PreparedStatement ps=null;

        String sql="insert into customers(name, email, birth, photo)values (?,?,?,?)";

        try {
            conn = JDBCutils.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setObject(1,"CUE!");
            ps.setObject(2,"ss@qq.com");
            ps.setObject(3,"2002-12-21");
            ps.setObject(4,new FileInputStream("C:\\Users\\lpl\\Desktop\\MA146001_bg.png"));

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCutils.closeResource(conn,ps);
        }

    }

    @Test
    public void show(){
        Connection conn=null;
        PreparedStatement ps=null;

        String sql="select photo from customers where photo is not null";

        try {
            conn = JDBCutils.getConnection();
            ps = conn.prepareStatement(sql);

            ResultSet resultSet = ps.executeQuery();

            int index=1;


            while (resultSet.next()){
                byte [] buffer = new byte[1024];
                int len = 0;
                Blob photo = resultSet.getBlob("photo");
                OutputStream os = new FileOutputStream("C:\\Users\\lpl\\Desktop"+"\\"+index+".png");
                index++;
                InputStream is = photo.getBinaryStream();
                while((len = is.read(buffer)) != -1){
                    os.write(buffer, 0, len);
                }

                if(is != null){
                    is.close();
                }

                if(os !=  null){
                    os.close();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCutils.closeResource(conn,ps);
        }

    }
}
