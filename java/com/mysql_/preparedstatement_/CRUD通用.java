package com.mysql_.preparedstatement_;

import com.mysql_.bean.Customer;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import static com.mysql_.util.JDBCutils.closeResource;
import static com.mysql_.util.JDBCutils.getConnection;

@SuppressWarnings("all")

public class CRUD通用 {

    public static void main(String[] args) throws IOException {
        FileInputStream fl = new FileInputStream("C:\\Users\\lpl\\Desktop\\CUE.PNG");
        byte []a=new byte[fl.available()];
        fl.read(a);
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\lpl\\Desktop\\1.PNG");
        fileOutputStream.write(a);

        fileOutputStream.close();
        fl.close();

    }
    @Test
    public void test(){
        String sql="select  id,name,email,birth from customers where  id=100;";
        ArrayList<Customer> customerArrayList = show(Customer.class, sql);
        for (int i = 0; i <customerArrayList.size() ; i++) {
            System.out.println(customerArrayList.get(i));
        }
    }
    public <T> ArrayList<T> show(Class<T> tClass,String sql, Object... obj) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        ArrayList<T> arr = new ArrayList<>();


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

//            for (T t : arr) {
//                System.out.println(t.toString());
//            }
            return arr;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            closeResource(conn, ps, resultSet);

        }
        return  null;
    }
}
