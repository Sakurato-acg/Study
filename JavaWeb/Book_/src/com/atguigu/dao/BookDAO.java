package com.atguigu.dao;

import com.atguigu.bean.Book;

import java.util.List;

public interface BookDAO {

    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryById(Integer id);

    public List<Book> queryBooks();

    Integer queryForPageTotalCount();

    List<Book> queryForPageItems(int begin, int pageSize);

    public Integer queryForPriceCount(int min,int max);

     List<Book> queryForPriceItems(int min,int max,int begin,int pageSize);

}
