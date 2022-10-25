package com.mysql_.DAO封装CRUD;

import com.mysql_.bean.Customer;
import com.mysql_.util.JDBCutils;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;

import static com.mysql_.util.JDBCutils.closeResource;


//封装了针对于数据表的通用的操作
@SuppressWarnings("all")
public abstract class BaseDao<T>{

    private Class<T> tClass=null;

    {
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType pa = (ParameterizedType) genericSuperclass;

        Type[] t = pa.getActualTypeArguments();
        tClass = (Class<T>) t[0];
    }

    public int testUpdate(Connection conn, String sql, Object... obj) {
        PreparedStatement ps = null;

        try {

            ps = conn.prepareStatement(sql);

            for (int i = 0; i < obj.length; i++) {
                ps.setObject(i + 1, obj[i]);
            }

            return  ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCutils.closeResource(null, ps);
        }
        return 0;
    }

    public  ArrayList<T> show(Connection conn, String sql, Object... obj) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        ArrayList<T> arr = new ArrayList<>();


        try {

            ps = conn.prepareStatement(sql);

            for (int i = 0; i < obj.length; i++) {
                ps.setObject(i + 1, obj[i]);
            }

            resultSet = ps.executeQuery();
            //获取结果集的元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                //获取 T 类 对象
                T t = tClass.newInstance();

                for (int i = 0; i < columnCount; i++) {

                    Object value = resultSet.getObject(i + 1);

                    String columnName = metaData.getColumnLabel(i + 1);


                    //通过反射 来赋值
                    Field field = tClass.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t, value);
                }
                arr.add(t);
            }
            return arr;

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            closeResource(null, ps, resultSet);
        }
        return  null;
    }

    public  T showSingle(Connection conn, String sql, Object... obj) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {

            ps = conn.prepareStatement(sql);

            for (int i = 0; i < obj.length; i++) {
                ps.setObject(i + 1, obj[i]);
            }

            resultSet = ps.executeQuery();
            //获取结果集的元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            if (resultSet.next()) {
                //获取 T 类 对象
                T t = tClass.newInstance();

                for (int i = 0; i < columnCount; i++) {

                    Object value = resultSet.getObject(i + 1);

                    String columnName = metaData.getColumnLabel(i + 1);


                    //通过反射 来赋值
                    Field field = tClass.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t, value);
                }
                return t;
            }


        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            closeResource(null, ps, resultSet);
        }
        return  null;
    }

    public <E>E getValue(Connection conn,String sql,Object...obj){
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
             ps = conn.prepareStatement(sql);

            for (int i = 0; i < obj.length ; i++) {
                ps.setObject(i+1,obj[i]);
            }

            rs=ps.executeQuery();
            if (rs.next()){
                return (E) rs.getObject(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCutils.closeResource(null,ps,rs);
        }
        return null;
    }
}
