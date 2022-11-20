package com.atguigu.test;

import com.atguigu.bean.Cart;
import com.atguigu.bean.Cart_Item;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@SuppressWarnings("all")
class CartTest {
    private Cart cart=new Cart();
    @Test
    void addItem() {
        cart.addItem(new Cart_Item(1,"java",1,new BigDecimal(20),new BigDecimal(20)));
        cart.addItem(new Cart_Item(1,"java",1,new BigDecimal(20),new BigDecimal(20)));
        cart.addItem(new Cart_Item(2,"c++",1,new BigDecimal(50),new BigDecimal(50)));

        System.out.println(cart);
    }

    @Test
    void deleteItem() {
        cart.addItem(new Cart_Item(1,"java",1,new BigDecimal(20),new BigDecimal(20)));
        cart.addItem(new Cart_Item(1,"java",1,new BigDecimal(20),new BigDecimal(20)));
        cart.addItem(new Cart_Item(2,"c++",1,new BigDecimal(50),new BigDecimal(50)));
        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    void updateCount() {
    }

    @Test
    void clear() {

    }
}