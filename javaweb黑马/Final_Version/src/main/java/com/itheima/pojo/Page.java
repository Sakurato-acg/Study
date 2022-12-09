package com.itheima.pojo;

import java.util.List;

public class Page<T>{
    private Integer total;
    private List<T> brands;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getBrands() {
        return brands;
    }

    public void setBrands(List<T> brands) {
        this.brands = brands;
    }

    @Override
    public String toString() {
        return "Page{" +
                "total=" + total +
                ", brands=" + brands +
                '}';
    }

    public Page() {
    }

    public Page(Integer total, List<T> brands) {
        this.total = total;
        this.brands = brands;
    }
}
