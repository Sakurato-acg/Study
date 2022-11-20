package com.atguigu.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Order {
    private String orderId;
    private Timestamp createTime;
    private BigDecimal price;
    private Integer status=NOT;
    private Integer userId;

    public static Integer NOT=0;
    public static Integer SEND=1;
    public static Integer GET=2;

    public Order() {
    }

    public Order(String orderId,Timestamp createTime, BigDecimal price, Integer status, Integer userId) {
        this.orderId = orderId;
        this.createTime = createTime;
        this.price = price;
        this.status = status;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", createTime=" + createTime +
                ", price=" + price +
                ", status=" + status +
                ", userId=" + userId +
                '}';
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public static Integer getNOT() {
        return NOT;
    }

    public static void setNOT(Integer NOT) {
        Order.NOT = NOT;
    }

    public static Integer getSEND() {
        return SEND;
    }

    public static void setSEND(Integer SEND) {
        Order.SEND = SEND;
    }

    public static Integer getGET() {
        return GET;
    }

    public static void setGET(Integer GET) {
        Order.GET = GET;
    }
}
