package com.atguigu.service;

import com.atguigu.bean.Cart;
import com.atguigu.bean.Order;
import com.atguigu.bean.OrderItem;

import java.util.List;

public interface OrderService {
    //生成订单
    public String createOrder(Cart cart,Integer userId);

    //查询全部订单
    public List<Order> showAllOrders();

    //发货,更改订单信息
    public int sendOrder(String orderId);

    //查看订单详情
    public List<OrderItem> showOrderDetail(String orderId);

    //查看我的订单
    public List<Order> showMyOrders(Integer userId);

    //签收订单,确定收货
    public int receiverOrder(String orderId);

}
