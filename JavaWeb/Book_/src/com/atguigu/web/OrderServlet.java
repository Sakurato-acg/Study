package com.atguigu.web;

import com.atguigu.bean.Cart;
import com.atguigu.bean.Order;
import com.atguigu.bean.OrderItem;
import com.atguigu.bean.User;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@SuppressWarnings("all")
public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            System.out.println("未登录");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
            return;
        }
        if (cart != null) {
            String orderId = orderService.createOrder(cart, user.getId());

            request.getSession().setAttribute("orderId", orderId);
            response.sendRedirect(request.getContextPath() + "/pages/cart/checkout.jsp");
        }
    }

    protected void showAllOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("查看项目订单");
        Object orderItems = request.getSession().getAttribute("orderItems");
        if (orderItems != null) {
            request.getSession().setAttribute("orderItems", null);
        }
        List<Order> orderList = orderService.showAllOrders();
        request.getSession().setAttribute("orderList", orderList);
        request.setAttribute("count", 1);
        request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request, response);
    }

    protected void showOrderDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("查看订单详情");
        String orderId = request.getParameter("orderId");
        List<OrderItem> orderItems = orderService.showOrderDetail(orderId);
        request.getSession().setAttribute("orderItems", orderItems);
        request.setAttribute("count", 2);
        request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request, response);
    }

    protected void sendOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("发货");
        String orderId = request.getParameter("orderId");
        System.out.println("orderId = " + orderId);
        orderService.sendOrder(orderId);
        response.sendRedirect(request.getHeader("Referer"));
    }


    protected void receiverOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("已完成");
        String orderId = request.getParameter("orderId");
        System.out.println("orderId = " + orderId);
        orderService.receiverOrder(orderId);
        response.sendRedirect(request.getHeader("Referer"));
    }


    protected void showMyOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            System.out.println("未登录");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
            return;
        }
        Integer id = user.getId();
        List<Order> myOrders = orderService.showMyOrders(id);
        request.getSession().setAttribute("myOrders",myOrders);
        request.getRequestDispatcher("/pages/order/order.jsp").forward(request,response);
    }
}

