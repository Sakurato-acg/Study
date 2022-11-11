package com.atguigu.service.impl;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.dao.BookDAO;
import com.atguigu.dao.impl.BookDAOImpl;
import com.atguigu.service.BookService;

import java.util.List;

@SuppressWarnings("all")
public class BookServiceImpl implements BookService {
    private BookDAO bookdao = new BookDAOImpl();

    @Override
    public void addBook(Book book) {
        bookdao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookdao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookdao.updateBook(book);
    }

    @Override
    public Book queryById(Integer id) {
        return bookdao.queryById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookdao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<Book>();

        Integer pageTotalCount = bookdao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);
        int total = (int) Math.ceil(pageTotalCount * 1.0 / page.getPageSize());
        page.setPageTotal(total);


        page.setPageNo(pageNo);


        int begin = (page.getPageNo() - 1) * pageSize;
        //求当前页数据
        List<Book> list = bookdao.queryForPageItems(begin, pageSize);

        page.setItems(list);


        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNO, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();

        //设置每页数量
        page.setPageSize(pageSize);

        //设置总记录数
        Integer count = bookdao.queryForPriceCount(min, max);
        page.setPageTotalCount(count);

        //设置总页码
        int total = (int) Math.ceil(count * 1.0 / page.getPageSize());
        page.setPageTotal(total);

        //设置当前页码
        page.setPageNo(pageNO);


        int begin = (page.getPageNo() - 1) * pageSize;
        List<Book> list = bookdao.queryForPriceItems(min, max, begin, pageSize);
        page.setItems(list);
        return page;
    }
}
