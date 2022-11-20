package com.atguigu.service.impl;

import com.atguigu.bean.*;
import com.atguigu.dao.BookDAO;
import com.atguigu.dao.OrderDAO;
import com.atguigu.dao.OrderItemDAO;
import com.atguigu.dao.impl.BookDAOImpl;
import com.atguigu.dao.impl.OrderImpl;
import com.atguigu.dao.impl.OrderItemImpl;
import com.atguigu.service.OrderService;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
public class OrderServiceImpl implements OrderService {
    private OrderDAO orderDAO=new OrderImpl();
    private OrderItemDAO itemDAO=new OrderItemImpl();
    private BookDAO bookDAO=new BookDAOImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        String orderId=System.currentTimeMillis()+"/"+userId;
        Order order=new Order(orderId, new Timestamp(new Date().getTime()),cart.getTotalPrice(),0,userId);

        orderDAO.saveOrder(order);

//        int i=12/0;
        for (Map.Entry<Integer,Cart_Item> entry:cart.getItems().entrySet()) {

            Cart_Item value = entry.getValue();
            OrderItem item=new OrderItem(null,value.getName(),value.getCount(),value.getPrice(),value.getTotalPrice(),orderId);
            itemDAO.saveOrderItem(item);


            Book book = bookDAO.queryById(value.getId());
            book.setSales(book.getSales()+cart.getTotalCount());
            book.setStock(book.getStock()-cart.getTotalCount());
            bookDAO.updateBook(book);
        }
        cart.clear();
        return orderId;
    }

    @Override
    public List<Order> showAllOrders() {
        return orderDAO.queryOrders();
    }

    @Override
    public int sendOrder(String orderId) {
        int status = orderDAO.changeOrderStatus(orderId, Order.SEND);
        return status;
    }

    @Override
    public List<OrderItem> showOrderDetail(String orderId) {
        return itemDAO.queryOrderItemsByOrderId(orderId);
    }

    @Override
    public List<Order> showMyOrders(Integer userId) {
        return orderDAO.queryOrdersByUserId(userId);
    }

    @Override
    public int receiverOrder(String orderId) {
        return orderDAO.changeOrderStatus(orderId,Order.GET);
    }
}
