package com.atguigu.dao;

import com.atguigu.bean.OrderItem;

import java.util.List;

public interface OrderItemDAO {
    public int saveOrderItem(OrderItem item);

    public List<OrderItem> queryOrderItemsByOrderId(String orderId);
}
