package com.mysql_.BLOB;

import com.mysql_.util.JDBCutils;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;


@SuppressWarnings("all")
public class 批量操作 {
    @Test
    public void insert(){
        Connection conn=null;
        PreparedStatement ps=null;

        //language=MySQL
        String sql1="insert into goods(name)values(?) ";
        String sql2=" DELETE FROM goods  WHERE NAME=?  ";
        try {
            //1.设置为不自动提交数据
            conn=JDBCutils.getConnection();

            conn.setAutoCommit(false);

            ps = conn.prepareStatement(sql1);

            for(int i = 1;i <= 20000;i++){
                ps.setString(1, "name_" + i);

                //1.“攒”sql
                ps.addBatch();

                if(i % 500 == 0){
                    //2.执行
                    ps.executeBatch();
                    //3.清空
                    ps.clearBatch();
                }
            }

            //2.提交数据
            conn.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCutils.closeResource(conn,ps);
        }
    }
}
