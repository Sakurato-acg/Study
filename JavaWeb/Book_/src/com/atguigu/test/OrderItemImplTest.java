package com.atguigu.test;

import com.atguigu.bean.OrderItem;
import com.atguigu.dao.OrderItemDAO;
import com.atguigu.dao.impl.OrderItemImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemImplTest {

    @Test
    void saveOrderItem() {
    }

    @Test
    void queryOrderItemsByOrderId() {
        OrderItemDAO orderItemDAO=new OrderItemImpl();
        List<OrderItem> orderItems = orderItemDAO.queryOrderItemsByOrderId("");
        orderItems.forEach(System.out::println);
    }
}