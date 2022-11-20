package com.atguigu.bean;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("all")
public class Cart {
    private Map<Integer, Cart_Item> items = new HashMap<>();
    //key商品编号 value商品信息

    /**
     * 添加商品项
     */
    public void addItem(Cart_Item cart_item) {
        //已添加
        Cart_Item item = items.get(cart_item.getId());

        if (item == null) {
            items.put(cart_item.getId(), cart_item);
        } else {
            item.setCount(item.getCount() + 1);
            item.setTotalPrice(item.getPrice().multiply(BigDecimal.valueOf(item.getCount())));
            items.put(cart_item.getId(), item);
        }

        //没添加
    }

    /**
     * 删除商品项
     */
    public void deleteItem(Integer id) {
        items.remove(id);
    }

    /**
     * 添加商品项
     */
    public void updateCount(Integer id, Integer count) {
        Cart_Item cart_item = items.get(id);
        if (cart_item != null) {
            cart_item.setCount(count);
            cart_item.setTotalPrice(cart_item.getPrice().multiply(BigDecimal.valueOf(cart_item.getCount())));
            items.put(id, cart_item);
        }
    }

    /**
     * 清空购物车
     */
    public void clear() {
        items.clear();
    }

    public Cart() {
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }

    public Integer getTotalCount() {
        Integer totalCount=0;
        for (Map.Entry<Integer, Cart_Item> entry : items.entrySet()) {
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }
    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice=new BigDecimal(0);
        for (Map.Entry<Integer, Cart_Item> entry : items.entrySet()) {
            totalPrice=totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }
    public Map<Integer,Cart_Item> getItems() {
        return items;
    }

    public void setItems(Map<Integer,Cart_Item> items) {
        this.items = items;
    }
}
