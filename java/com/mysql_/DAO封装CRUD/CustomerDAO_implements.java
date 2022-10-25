package com.mysql_.DAO封装CRUD;

import com.mysql_.bean.Customer;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAO_implements extends BaseDao<Customer> implements CustomerDAO {



    @Override
    public void insert(Connection conn, Customer cust) {
       String sql= "insert into customers(name, email, birth) values (?,?,?,?)";

       testUpdate(conn,sql,cust.getName(),cust.getEmail(),cust.getBirth());
    }

    @Override
    public void delete_ByID(Connection conn, int id) {
        String sql="delete from customers where id=?";
        testUpdate(conn,sql,id);
    }

    @Override
    public void update(Connection conn, Customer customer) {
        String sql="update customers set name=?,email=?,birth=? where  id=?";

        testUpdate(conn,sql,customer.getName(),customer.getEmail(),customer.getBirth(),customer.getId());
    }

    @Override
    public Customer select_CustomerById(Connection conn, int id) {
        String sql="select  `name`,email,birth from customers where id=?";
        return  showSingle(conn,sql,id);

    }

    @Override
    public ArrayList<Customer> get_ALL_Customer_ById(Connection conn) {
        String sql="select  `name`,email,birth from customers ";
        return  show(conn,sql);
    }

    @Override
    public Long getCount(Connection conn) {
        String sql="select  count(*)from customers";
        return getValue(conn,sql);
    }

    @Override
    public Date get_MAX_Birth(Connection conn) {
        String sql="select  MAX(birth) from customers";
        return getValue(conn,sql);
    }
}
