package com.atguigu.test;

import com.atguigu.bean.Order;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder() {
    }

    @Test
    void showAllOrders() {
        OrderService orderService=new OrderServiceImpl();
        List<Order> orders = orderService.showAllOrders();
        orders.forEach(System.out::println);
    }

    @Test
    void sendOrder() {
    }

    @Test
    void showOrderDetail() {
    }

    @Test
    void showMyOrders() {
        OrderService orderService=new OrderServiceImpl();
        List<Order> myOrders = orderService.showMyOrders(1);
        myOrders.forEach(System.out::println);
    }

    @Test
    void receiverOrder() {
    }
}