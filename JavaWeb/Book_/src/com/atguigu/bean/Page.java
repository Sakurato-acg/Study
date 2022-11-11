package com.atguigu.bean;

import java.util.List;

@SuppressWarnings("all")
public class Page<T> {

    public static final Integer PAGE_SIZE =4;
    //当前页码
    private Integer pageNo;
    //总页码
    private Integer pageTotal;
    //当前页面数量
    private Integer pageSize=PAGE_SIZE;

    private Integer pageTotalCount;

    private List<T> items;

    private String url;

//    private int min;
//    private int max;
//
//    public int getMin() {
//        return min;
//    }
//
//    public void setMin(int min) {
//        this.min = min;
//    }
//
//    public int getMax() {
//        return max;
//    }
//
//    public void setMax(int max) {
//        this.max = max;
//    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageSize=" + pageSize +
                ", pageTotalCount=" + pageTotalCount +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        if (pageNo < 1) {
            pageNo = 1;
        }
        if (pageNo>pageTotal){
            pageNo=pageTotal;
        }
        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
