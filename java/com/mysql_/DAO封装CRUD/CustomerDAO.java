package com.mysql_.DAO封装CRUD;
//规范对于C表的通用操作

import com.mysql_.bean.Customer;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

public interface CustomerDAO {

    void insert(Connection conn, Customer cust);

    void delete_ByID(Connection conn,int id);

    void update(Connection conn ,Customer customer );

    ArrayList<Customer> select_CustomerById(Connection conn, int id);

    ArrayList<Customer> get_ALL_Customer_ById(Connection conn);

    Long getCount(Connection  conn);

    Date get_MAX_Birth(Connection conn);


}
