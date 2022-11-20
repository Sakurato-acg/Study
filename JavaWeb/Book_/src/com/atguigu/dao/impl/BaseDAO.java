package com.atguigu.dao.impl;

import com.atguigu.utils.JDBCUtils;
import com.mysql.cj.jdbc.JdbcConnection;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SuppressWarnings("all")
public class BaseDAO {
    private final QueryRunner queryRunner = new QueryRunner();

    /**
     * update()方法用于执行:Insert\Update\Delete
     *
     * @return 如果返回-1 表示执行失败
     **/

    public int update(String sql, Object... args) {
        Connection conn = JDBCUtils.getConnection();
        int update = -1;
        try {
            return update = queryRunner.update(conn, sql, args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * @param type 返回的对象类型
     * @param sql  执行的sql语句
     * @param args 参数值
     * @param <T>  返回泛型对象
     * @author lpl
     * @Description 查询返回一个javabean
     **/

    public <T> T queryForOne(Class<T> type, String sql, Object... args) {
        Connection conn = JDBCUtils.getConnection();
        try {
            BeanHandler<T> handler = new BeanHandler<T>(type);
            return queryRunner.query(conn, sql, handler, args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public <T> List<T> queryForList(Class<T> type, String sql, Object... args) {
        Connection conn = JDBCUtils.getConnection();
        try {
            BeanListHandler<T> handler = new BeanListHandler<>(type);
            List<T> query = queryRunner.query(conn, sql, handler, args);
            return query;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Object queryForSingleValue(String sql, Object... args) {
        Connection conn =JDBCUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
