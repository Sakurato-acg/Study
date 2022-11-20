package com.atguigu.test;

import com.atguigu.bean.Order;
import com.atguigu.dao.OrderDAO;
import com.atguigu.dao.impl.OrderImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderImplTest {

    @Test
    void saveOrder() {
    }

    @Test
    void queryOrders() {
        OrderDAO orderDAO=new OrderImpl();
        List<Order> orders = orderDAO.queryOrders();
        for (Order order:orders) {
            String[] s = order.getCreateTime().toString().split(" ");
            System.out.println(s[0]);
        }
    }

    @Test
    void changeOrderStatus() {
    }

    @Test
    void queryOrdersByUserId() {
    }
}