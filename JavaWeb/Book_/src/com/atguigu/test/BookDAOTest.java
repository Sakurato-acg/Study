package com.atguigu.test;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.dao.BookDAO;
import com.atguigu.dao.impl.BookDAOImpl;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookDAOTest {
    private BookDAO bookDao=new BookDAOImpl();
    @Test
    void addBook() {
    }

    @Test
    void deleteBookById() {
    }

    @Test
    void updateBook() {
    }

    @Test
    void queryById() {
        Book book = bookDao.queryById(1);
        System.out.println(book);
    }

    @Test
    void queryBooks() {
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        bookDao.queryForPageItems(8, 4).forEach(System.out::println);
    }
}