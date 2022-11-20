package com.atguigu.dao;

import com.atguigu.bean.Cart;
import com.atguigu.bean.Order;

import java.util.List;

public interface OrderDAO {

    public int saveOrder(Order order);

    public List<Order> queryOrders();

    public int changeOrderStatus(String orderId, Integer status);

    public  List<Order> queryOrdersByUserId(Integer userId);
}
