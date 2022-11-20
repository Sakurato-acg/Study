package com.atguigu.dao.impl;

import com.atguigu.bean.Order;
import com.atguigu.dao.OrderDAO;

import java.util.List;

public class OrderImpl extends BaseDAO implements OrderDAO {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into book.t_order(`order_id`, `create_time`, `price`, `status`, `user_id`) VALUES (?,?,?,?,?)";
        return update(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }

    @Override
    public List<Order> queryOrders() {
        String sql = "select `order_id` AS 'orderId' , `create_time` AS 'createTime', `price`, `status`, `user_id` AS 'userId' from book.t_order";
        return queryForList(Order.class, sql);
    }

    @Override
    public int changeOrderStatus(String orderId, Integer status) {
        String sql = "update book.t_order set `status`=? where order_id=?";
        return update(sql, status, orderId);
    }

    @Override
    public List<Order> queryOrdersByUserId(Integer userId) {
        String sql = "select `order_id` AS 'orderId', `create_time` AS 'createTime', `price`, `status`, `user_id` AS 'userId' from book.t_order where `user_id`=?";
        return queryForList(Order.class,sql,userId);
    }
}
