package com.atguigu.dao.impl;

import com.atguigu.bean.OrderItem;
import com.atguigu.dao.OrderItemDAO;

import java.util.List;

public class OrderItemImpl extends BaseDAO  implements OrderItemDAO {
    @Override
    public int saveOrderItem(OrderItem item) {
        String sql="insert into book.t_order_item(`name`, `count`, `price`,`total_price`, `order_id`) values (?,?,?,?,?)";
        return update(sql,item.getName(),item.getCount(),item.getPrice(),item.getTotalPrice(),item.getOrderId());
    }

    @Override
    public List<OrderItem> queryOrderItemsByOrderId(String orderId) {
        String sql="select `id`, `name`, `count`, `price`, `total_price` AS `totalPrice`, `order_id` AS `orderId`from book.t_order_item where `order_id`=?";
        return queryForList(OrderItem.class,sql,orderId);
    }
}
