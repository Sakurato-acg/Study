package com.mysql_.transaction事务;

import com.mysql_.util.JDBCutils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class transaction_ {

    /** 事务:
        一组逻辑操作单位，是的数据从一种状态变换到另一种状态
     **/


    @Test
    public void test() {
        Connection conn = null;
        try {
            conn = JDBCutils.getConnection();

            conn.setAutoCommit(false);


            String sql1 = "update  user_table set balance = balance-100 where user=? ";
            testUpdate(conn, sql1, "AA");


           // System.out.println(10/0);


            String sql2 = "update  user_table set balance = balance + 100 where user=? ";

            testUpdate(conn, sql2, "BB");

            System.out.println("转账成功");

            conn.commit();

        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (conn != null)
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (conn!=null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void testUpdate(Connection conn, String sql, Object... obj) {
        PreparedStatement ps = null;

        try {

            ps = conn.prepareStatement(sql);

            for (int i = 0; i < obj.length; i++) {
                ps.setObject(i + 1, obj[i]);
            }

             ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCutils.closeResource(null, ps);
        }

    }
}
